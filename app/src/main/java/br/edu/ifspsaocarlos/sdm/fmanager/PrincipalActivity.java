package br.edu.ifspsaocarlos.sdm.fmanager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PrincipalActivity extends AppCompatActivity implements View.OnClickListener{
    /* FragmentManager gerencia o ciclo de vida dos Fragmentos de uma tela. Assim como os Fragmentos
    o FragmentManager usado é do pacote android.support.v4.app.* */
    private FragmentManager fragmentManager;

    // Fragmentos que serão alternados e ocuparão o FrameLayout
    private Fragmento1Fragment fragmento1Fragment;
    private Fragmento2Fragment fragmento2Fragment;

    /* Constantes de texto que serão usadas no gerenciamento dos Fragmentos. Sempre que um Fragmento
    é usado, é possível associar uma TAG a esse uso. Com essa TAG podemos, por exemplo, saber se um
    Fragmento já foi usado pelo FragmentManager para ocupar uma FrameLayout. */
    private final String TAG_F1 = "FRAGMENTO_1";
    private final String TAG_F2 = "FRAGMENTO_2";

    private Button mudaFragmentoBT;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        // Instanciando os Fragmentos
        fragmento1Fragment = new Fragmento1Fragment();
        fragmento2Fragment = new Fragmento2Fragment();

        // Referenciando o FragmentManager desta Activity
        fragmentManager = getSupportFragmentManager();

        // Iniciando o FrameLayout com o Fragmento 1
        fragmentManager.beginTransaction().replace(R.id.fl_principal, fragmento1Fragment, TAG_F1).commit();

        // Buscando referência para o Botão e configurando seu Listener
        mudaFragmentoBT = findViewById(R.id.bt_muda_fragmento);
        mudaFragmentoBT.setOnClickListener(this);
    }

    public void onClick(View v) {
        if (v == mudaFragmentoBT) {
            /* Buscando pelo Fragmento 1 no FragmentManager. Se o retorno for um objeto, então o
             Fragmento 1 está ocupando o FrameLayout. Se o retorno for nulo, então o Fragmento 2 está
             ocupando o FrameLayout. */
            Fragment fragment = fragmentManager.findFragmentByTag(TAG_F1);
            if (fragment == null){
                fragmentManager.beginTransaction().replace(R.id.fl_principal, fragmento1Fragment, TAG_F1).commit();
            }
            else {
                fragmentManager.beginTransaction().replace(R.id.fl_principal, fragmento2Fragment, TAG_F2).commit();
            }
        }
    }
}
