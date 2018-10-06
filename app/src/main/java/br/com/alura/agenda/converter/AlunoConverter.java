package br.com.alura.agenda.converter;

import org.json.JSONException;
import org.json.JSONStringer;

import java.util.List;

import br.com.alura.agenda.modelo.Aluno;

public class AlunoConverter {

    public String converterParaJson(List<Aluno> alunos) {
        JSONStringer js = new JSONStringer();

 /****
  * js.object(). - representa a chamada de um objeto, no arquivo json se inicia por chaves {}
  * key("List"). - é uma chave associada a um valor e neste caso, é uma Lista
  * array().    - para avisar o Json que foi aberta uma lista
  * object().   - para a abertura de outro objeto
  * key("aluno").  é uma chave associada a um valor e neste caso, é o aluno
  * array(), - para avisar o Json que foi aberta uma lista de alunos
  *
  * Exemplo:
  * {
      "List":
            [
                {
                "aluno":
                        [
                          {
                          "id": "1",
                          "nome":"Eron",
                          "endereco":"ddddddd",
                          "telefone":"88888888",
                          "site":"www.uol.com.br",
                          "nota":"4"
                          },

                          {
                          "id": "2",
                          "nome":"Thiago",
                          "endereco":"Rua tres",
                          "telefone":"15975321",
                          "site":"www.mercadolivre.com",
                          "nota":"0"
                          }
                        ]
                }
             ]
        }
  *
  *
  *
  * */
//Em codigo, utilizando a classe JSONStringer, estruturando exatamente como no arquivo
        try {
            js.object(). //abre chaves {
                       key("List"). //atrbui uma chave: "List"
                               array().//abre colchetes [
                                   object(). // abre chaves {
                                     key("aluno"). //atrbui uma chave: "aluno"
                                            array();//abre colchetes [
                                            for (Aluno aluno: alunos){ //percorrendo por todos os alunos
                                                js.object(); //abre chaves {
                                                js.key("nome").value(aluno.getNome()); // atribui a chave "nome" o nome do aluno
                                                js.key("nota").value(aluno.getNota()); // atribui a chave "nota" a nota do aluno
                                                js.endObject();//fecha chaves }
                                            }
                                     js.endArray().//fecha colchetes ]
                                   endObject().//fecha chaves }
                               endArray().//fecha colchetes ]
            endObject();//fecha chaves }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return js.toString();
    }
}
