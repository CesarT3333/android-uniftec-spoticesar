package spoticesar.uniftec.com.br.spoticesar.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import spoticesar.uniftec.com.br.spoticesar.R;
import spoticesar.uniftec.com.br.spoticesar.models.Telefone;

public class CadastroTelefoneActivity
        extends AppCompatActivity
        implements View.OnClickListener {

    private EditText edtNome;
    private EditText edtEndereco;
    private EditText edtTelefone;

    private Button btnSalvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_telefone);

        this.findCOmponents();

    }

    private void findCOmponents() {

        this.edtEndereco = this.findViewById(R.id.edt_crud_endereco);
        this.edtNome = this.findViewById(R.id.edt_crud_nome);
        this.edtTelefone = this.findViewById(R.id.edt_crud_telefone);

        this.btnSalvar = this.findViewById(R.id.btn_salvar_telefone);

        this.btnSalvar.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {


        if (v == this.btnSalvar) {
            this.salvarTelefone();
        }

    }

    private void salvarTelefone() {

        Telefone tel = new Telefone(
                this.edtNome.getText().toString(),
                this.edtEndereco.getText().toString(),
                this.edtTelefone.getText().toString()
        );

        System.out.println(tel.toString());

    }

}
