package br.com.alura.agenda.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

import br.com.alura.agenda.DetalhesProvaActivity;
import br.com.alura.agenda.R;
import br.com.alura.agenda.modelo.Prova;

public class ListaProvasFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {

       View view =  inflater.inflate(R.layout.fragment_lista_provas,container,false);
        List<String> topicosPort = Arrays.asList("Sujeito", "Objeto Direto", "Objeto Indireto");
        Prova provaPortugues = new Prova("Portugues", "28/08/2018", topicosPort);


        List<String> topicosMat = Arrays.asList("Trigonometria", "Equacao de segundo grau", "plano cartesiano");
        Prova provaMatematica = new Prova("Matematica", "29/08/2018", topicosMat);

        List<Prova> provas = Arrays.asList(provaPortugues,provaMatematica);

        ArrayAdapter<Prova> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, provas);
        ListView lista = view.findViewById(R.id.provas_lista);

        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Prova prova = (Prova) parent.getItemAtPosition(position);
                Toast.makeText(getContext(),"Clicou na prova de: "+ prova, Toast.LENGTH_LONG).show();
                Intent vaiParaDetalhes = new Intent(getContext(), DetalhesProvaActivity.class);
                vaiParaDetalhes.putExtra("prova", prova);
                startActivity(vaiParaDetalhes);



            }
        });
        return view;
    }
}
