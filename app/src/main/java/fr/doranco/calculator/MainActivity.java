package fr.doranco.calculator;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private static final String TAG ="MainActivity";

    TextView textView;
    EditText editText;
    Button  bouton0,
            bouton1,
            bouton2,
            bouton3,
            bouton4,
            bouton5,
            bouton6,
            bouton7,
            bouton8,
            bouton9,
            boutonPlus,
            boutonMoins,
            boutonMultiplier,
            boutonDiviser,
            boutonEgal,
            boutonC,
            boutonVirgule,
            boutonCE;

    Float valeur1, valeur2;
    boolean isAddition = false, isSubstruct = false, isMultiply = false, isDivide = false;
    boolean isOperationFished;

    private static final String PREF_USER_VALUE1 = "PREF_USER_VALUE1";
    private static final String PREF_USER_VALUE2 = "PREF_USER_VALUE2";
    private static final String PREF_USER_OPERATEUR = "PREF_USER_OPERATEUR";
    private static final String PREF_USER_RESULTAT = "PREF_USER_RESULTAT";
    private SharedPreferences mPreferences; // contiendra les infos qu'on souhaite sauvegarder sur le téléphone

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            editText = findViewById(R.id.editView);
            bouton0 = findViewById(R.id.bouton0);
            bouton1 = findViewById(R.id.bouton1);
            bouton2 = findViewById(R.id.bouton2);
            bouton3 = findViewById(R.id.bouton3);
            bouton4 = findViewById(R.id.bouton4);
            bouton5 = findViewById(R.id.bouton5);
            bouton6 = findViewById(R.id.bouton6);
            bouton7 = findViewById(R.id.bouton7);
            bouton8 = findViewById(R.id.bouton8);
            bouton9 = findViewById(R.id.bouton9);
            boutonPlus = findViewById(R.id.boutonPlus);
            boutonMoins = findViewById(R.id.boutonMoins);
            boutonDiviser = findViewById(R.id.boutonDiviser);
            boutonMultiplier = findViewById(R.id.boutonMultiplier);
            boutonEgal = findViewById(R.id.boutonEgal);
            boutonC = findViewById(R.id.boutonC);
            boutonVirgule = findViewById(R.id.boutonVirgule);
            boutonCE = findViewById(R.id.boutonCE);

        mPreferences = getPreferences(MODE_PRIVATE); // => seule notre application aura accès à ces données

        DecimalFormat format  = new DecimalFormat("#######.##");
        format.setMinimumFractionDigits(2);
        format.setMaximumFractionDigits(2);
        editText.setText(format.format(0));

        // or

//                editText.setFilters(new InputFilter[]{new DigitsInputFilter(8, 2, 99999999.99)});

        // or

//        @BindingAdapter({"digitsBeforeZero", "digitsAfterZero"})
//        public void bindAmountInputFilter(EditText view, int digitsBeforeZero, int digitsAfterZero) {
//            view.setFilters(new InputFilter[]{new DecimalDigitsInputFilter(digitsBeforeZero, digitsAfterZero)});
//        }
//      then put this code in xml :
//        app:digitsBeforeZero="@{7}"
//        app:digitsAfterZero="@{2}"


            editText.setText("0");

            bouton0.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    initialiserChampsTexte();
                    editText.setText(editText.getText() + "0");
                }
            });

        bouton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initialiserChampsTexte();
                editText.setText(editText.getText() + "1");
            }
        });

        bouton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initialiserChampsTexte();
                editText.setText(editText.getText() + "2");
            }
        });

        bouton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initialiserChampsTexte();
                editText.setText(editText.getText() + "3");
            }
        });

        bouton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initialiserChampsTexte();
                editText.setText(editText.getText() + "4");
            }
        });

        bouton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initialiserChampsTexte();
                editText.setText(editText.getText() + "5");
            }
        });

        bouton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initialiserChampsTexte();
                editText.setText(editText.getText() + "6");
            }
        });

        bouton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initialiserChampsTexte();
                editText.setText(editText.getText() + "7");
            }
        });

        bouton8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initialiserChampsTexte();
                editText.setText(editText.getText() + "8");
            }
        });

        bouton9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initialiserChampsTexte();
                editText.setText(editText.getText() + "9");
            }
        });

        boutonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               if(!(isAddition || isSubstruct || isMultiply || isDivide)) {
                   valeur1 = Float.parseFloat(editText.getText().toString());
               }
               initiliseOperateurs();
                editText.setText("0");
                isAddition = true;
            }
        });

        boutonMoins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!(isAddition || isSubstruct || isMultiply || isDivide)) {
                    valeur1 = Float.parseFloat(editText.getText().toString());
                }
                initiliseOperateurs();
                editText.setText("0");
                isSubstruct = true;
            }
        });

        boutonMultiplier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!(isAddition || isSubstruct || isMultiply || isDivide)) {
                    valeur1 = Float.parseFloat(editText.getText().toString());
                }
                initiliseOperateurs();
                editText.setText("0");
                isMultiply = true;
            }
        });

        boutonDiviser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!(isAddition || isSubstruct || isMultiply || isDivide)) {
                    valeur1 = Float.parseFloat(editText.getText().toString());
                }
                initiliseOperateurs();
                editText.setText("0");
                isDivide = true;            }
        });

        boutonEgal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                valeur2 = Float.parseFloat(editText.getText().toString());
                if (isAddition) {
                    editText.setText((valeur1 + valeur2) == 0.0f ? "0" : String.valueOf(valeur1 + valeur2));
                }
                if (isSubstruct) {
                    editText.setText((valeur1 - valeur2) == 0.0f ? "0" : String.valueOf(valeur1 - valeur2));
                }
                if (isMultiply) {
                    editText.setText((valeur1 * valeur2) == 0.0f ? "0" : String.valueOf(valeur1 * valeur2));
                }
                if (isDivide) {
                    if (valeur2 == 0) {
                        textView.setText("Division par 0 interdite !");
                        textView.setTextColor(Color.RED);


                    } else {
                        editText.setText((valeur1 / valeur2) == 0.0f ? "0" : String.valueOf(valeur1 / valeur2));
                    }
                }
                initiliseOperateurs();
                isOperationFished = true;
            }
        });

        boutonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText("0");
            }
        });

        boutonCE.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText("");
                editText.setText(editText.getText() + "0");
            }
        }));


        boutonVirgule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText() + ".");
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG, "onStart get Value :: " + mPreferences.getString(PREF_USER_VALUE1, "NONE"));
        if (editText.getText().toString().equals("0") || editText.getText().toString().equals("0.00")) {
            String value = mPreferences.getString(PREF_USER_VALUE1, "0");
            Log.d(TAG, "Valeur récupérée = " + value);
            editText.setText(value);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        mPreferences.edit().putString(PREF_USER_VALUE1, editText.getText().toString()).apply();
        Log.e(TAG, "onStop put Value :: " + mPreferences.getString(PREF_USER_VALUE1, "NONE"));
    }

    // cette méthode remplace le listener du bouton 9
    public void setText9(View view) {
        initialiserChampsTexte();
        editText.setText(editText.getText() + "9");
    }



    //METHODES
    private void initialiserChampsTexte() {
        if(!isOperationFished) {
            editText.setText("");
            isOperationFished = false;
        }
        if(editText.getText().toString().equals("0"))
            editText.setText("");
    }


    private void initiliseOperateurs() {
        isAddition = false;
        isDivide = false;
        isSubstruct = false;
        isMultiply = false;
    }

}
