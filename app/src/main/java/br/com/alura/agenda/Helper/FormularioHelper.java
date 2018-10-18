package br.com.alura.agenda.Helper;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;

import br.com.alura.agenda.FormularioActivity;
import br.com.alura.agenda.R;
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
    private final ImageView campoFoto;
    private Aluno aluno;

    FormularioHelper(FormularioActivity activity){
        campoNome       = activity.findViewById(R.id.formulario_Nome);
        campoEndereco   = activity.findViewById(R.id.formulario_Endereco);
        campoTelefone   = activity.findViewById(R.id.formulario_Telefone);
        campoSite       = activity.findViewById(R.id.formulario_Site);
        campoNota       = activity.findViewById(R.id.formulario_RatingBar);
        campoFoto       = activity.findViewById(R.id.formulario_foto);
        aluno           = new Aluno();
    }



    public Aluno pegaAluno() {
        aluno.setNome(campoNome.getText().toString());
        aluno.setEndereco(campoEndereco.getText().toString());
        aluno.setTelefone(campoTelefone.getText().toString());
        aluno.setSite(campoSite.getText().toString());
        aluno.setNota((double) campoNota.getProgress());
        aluno.setCaminhoFoto((String) campoFoto.getTag());

        return aluno;
    }

    public void preencheFormulario(Aluno aluno) {

        campoNome.setText(aluno.getNome());
        campoEndereco.setText(aluno.getEndereco());
        campoTelefone.setText(aluno.getTelefone());
        campoSite.setText(aluno.getSite());
        campoNota.setProgress(aluno.getNota().intValue());
        carregaImagem(aluno.getCaminhoFoto());

        this.aluno = aluno;
    }

    public void carregaImagem(String caminhoFoto) {
        if(caminhoFoto != null) {
            Bitmap bitmap = BitmapFactory.decodeFile(caminhoFoto);
            Bitmap bitmapReduzido = Bitmap.createScaledBitmap(bitmap, 300, 300, true);
            campoFoto.setImageBitmap(bitmapReduzido);
            campoFoto.setScaleType(ImageView.ScaleType.FIT_XY);
            campoFoto.setTag(caminhoFoto);
        }
    }
}
