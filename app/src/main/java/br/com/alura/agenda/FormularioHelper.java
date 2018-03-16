package br.com.alura.agenda;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;

import br.com.alura.agenda.modelo.Aluno;

/**
 * Created by Eron on 01/02/2018.
 */

public class FormularioHelper {
    private final EditText campoNome;
    private final EditText campoEndereco;
    private final EditText campoTelefone;
    private final EditText campoSite;
    private final RatingBar campoNota;


    public FormularioHelper(FormularioActivity activity){
        campoNome       = (EditText) activity.findViewById(R.id.formulario_Nome);
        campoEndereco   = (EditText) activity.findViewById(R.id.formulario_Endereco);
        campoTelefone   = (EditText) activity.findViewById(R.id.formulario_Telefone);
        campoSite       = (EditText) activity.findViewById(R.id.formulario_Site);
        campoNota       = (RatingBar)activity.findViewById(R.id.formulario_RatingBar);
    }



    public Aluno pegaAluno() {
        Aluno aluno = new Aluno();
        aluno.setNome(campoNome.getText().toString());
        aluno.setEndereco(campoEndereco.getText().toString());
        aluno.setTelefone(campoTelefone.getText().toString());
        aluno.setSite(campoSite.getText().toString());
        aluno.setNota(Double.valueOf(campoNota.getProgress()));

        return aluno;
    }
}
