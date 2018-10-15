package br.com.alura.agenda.task;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.util.List;

import br.com.alura.agenda.web.WebClient;
import br.com.alura.agenda.converter.AlunoConverter;
import br.com.alura.agenda.dao.AlunoDAO;
import br.com.alura.agenda.modelo.Aluno;

public class EnviaAlunosTask extends AsyncTask<Object,Object,String> {
    private Context context;
    private ProgressDialog progressDialog;

    public EnviaAlunosTask(Context context) {
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = ProgressDialog.show(context,"Aguarde!!!", "Enviando para o servidor",true,true);

    }

    @Override
    protected String doInBackground(Object... objects) {
        WebClient client = new WebClient();
        AlunoConverter conversor = new AlunoConverter();
        AlunoDAO dao = new AlunoDAO(context);
        List<Aluno> alunos = dao.buscarAlunos();
        dao.close();
        String json = conversor.converterParaJson(alunos);
        String resposta = client.post(json);
        return resposta;
    }

    @Override
    protected void onPostExecute(String resposta) {
        progressDialog.dismiss();
        Toast.makeText(context, resposta, Toast.LENGTH_LONG).show();
    }
}
