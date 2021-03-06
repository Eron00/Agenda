package br.com.alura.agenda.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.telephony.SmsMessage;
import android.widget.Toast;

import br.com.alura.agenda.R;
import br.com.alura.agenda.dao.AlunoDAO;

public class SMSReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {


            Object[] pdus = (Object[]) intent.getSerializableExtra("pdus");
            byte[] pdu = (byte[]) pdus[0];
            String formato = (String) intent.getSerializableExtra("format");

            SmsMessage sms = SmsMessage.createFromPdu(pdu, formato);
            String telefone = sms.getDisplayOriginatingAddress();

            AlunoDAO alunoDAO = new AlunoDAO(context);

            if(alunoDAO.ehAluno(telefone)) {
                Toast.makeText(context, "Chegou um SMS de Aluno", Toast.LENGTH_SHORT).show();
                MediaPlayer mediaPlayer = MediaPlayer.create(context, R.raw.msg);
                mediaPlayer.start();
            }
            alunoDAO.close();
    }
}
