package com.example.projetoongvidaa;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Cadastro extends AppCompatActivity {

    private Button toVitrine;
    private Button backMain;

    // Declaração das variáveis para os campos de texto
    private EditText editTextNome;
    private EditText editTextEndereco;
    private EditText editTextCpf;
    private EditText editTextRg;
    private EditText editTextDataNascimento;
    private EditText editTextContato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cadastro);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Inicializar os campos de texto
        editTextNome = findViewById(R.id.editTextNome);
        editTextEndereco = findViewById(R.id.editTextEndereco);
        editTextCpf = findViewById(R.id.editTextCpf);
        editTextRg = findViewById(R.id.editTextRg);
        editTextDataNascimento = findViewById(R.id.editTextDataNascimento);
        editTextContato = findViewById(R.id.editTextContato);

        // Botão para retornar à MainActivity
        backMain = findViewById(R.id.returnHome);
        backMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Cadastro.this, MainActivity.class);
                startActivity(intent);
            }
        });

        // Botão para enviar os dados por email
        toVitrine = findViewById(R.id.enviar);
        toVitrine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Captura os dados dos campos
                String nome = editTextNome.getText().toString();
                String endereco = editTextEndereco.getText().toString();
                String cpf = editTextCpf.getText().toString();
                String rg = editTextRg.getText().toString();
                String dataNascimento = editTextDataNascimento.getText().toString();
                String contato = editTextContato.getText().toString();

                // Composição do corpo do email
                String mensagem = "Dados do Usuário:\n\n" +
                        "Nome: " + nome + "\n" +
                        "Endereço: " + endereco + "\n" +
                        "CPF: " + cpf + "\n" +
                        "RG: " + rg + "\n" +
                        "Data de Nascimento: " + dataNascimento + "\n" +
                        "Contato: " + contato;

                // Intent para enviar email
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
                emailIntent.setData(Uri.parse("mailto:")); // Garante que somente apps de email serão chamados
                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"rodrigocarrard.pessoal@gmail.com"});
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Informações do Usuário");
                emailIntent.putExtra(Intent.EXTRA_TEXT, mensagem);

                // Verifica se existe um app de email configurado e o inicia
                if (emailIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(emailIntent);
                } else {
                    // Mensagem de erro (caso não haja app de email disponível)
                    System.out.println("Nenhum aplicativo de email encontrado.");
                }
            }
        });
    }
}
