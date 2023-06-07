package sg.edu.rp.c346.id22000028.simpletodo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // Declare variables
    EditText inputToDo;
    Button addBtn, clearBtn, deleteBtn;
    ListView todoList;
    ArrayList<String> alTodo;
    ArrayAdapter<String> aaTodo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize variables
        inputToDo = findViewById(R.id.editTextTodo);
        addBtn = findViewById(R.id.buttonAddItem);
        clearBtn = findViewById(R.id.buttonClearItem);
        todoList = findViewById(R.id.listViewTodo);
        deleteBtn = findViewById(R.id.buttonDeleteItem);

        alTodo = new ArrayList<>();

        aaTodo = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, alTodo);
        todoList.setAdapter(aaTodo);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newTodo = inputToDo.getText().toString();
                alTodo.add(newTodo);
                aaTodo.notifyDataSetChanged();
                inputToDo.setText("");
            }
        });

        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputText = inputToDo.getText().toString();
                if (!inputText.isEmpty()) {
                    alTodo.remove(inputText);
                    aaTodo.notifyDataSetChanged();
                    inputToDo.setText("");
                }
            }
        });
    }
}
