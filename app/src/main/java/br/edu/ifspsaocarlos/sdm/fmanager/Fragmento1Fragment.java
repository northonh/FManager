package br.edu.ifspsaocarlos.sdm.fmanager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Por se tratar de um aplicativo que terá suporte a versões anteriores do Android, a classe
 * Fragment importada é a android.support.v4.app.Fragment
 */
public class Fragmento1Fragment extends Fragment {
    /*
      O método onCreateView faz parte do ciclo de vida de um Fragmento e sua função é basicamente
      retornar o layout que dá a cara do Fragmento. Neste caso, vamos inflar o layout definido em
      fragment_layout, preencher o TextView desse layout com uma frase que identifique este
      Fragmento e vamos retornar esse layout modificado. */
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflando o layout de fragment_layout com o inflater
        View view = inflater.inflate(R.layout.fragment_layout, null);

        // Recuperando referência para o TextView e alterando seu conteúdo
        TextView textoTV = view.findViewById(R.id.tv_texto);
        textoTV.setText(R.string.mensagem_fragmento_1);

        // Retornando o layout inflado
        return view;
    }
}
