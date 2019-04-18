package com.lambdaschool.build_week3_simpsons_says;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link LoginFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link LoginFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LoginFragment extends DialogFragment {

    public static final String SHARED_PREFERENCES_USERNAME = "username";
    public static final String ARG_PARAM = "login";
    private String paramUsername;

    private OnFragmentInteractionListener mListener;

    public LoginFragment() {
        // Required empty public constructor
    }

    public static LoginFragment newInstance(String param1) {
        LoginFragment fragment = new LoginFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            paramUsername = getArguments().getString(ARG_PARAM);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final Context context = getContext();
        final View rootView = inflater.inflate(R.layout.fragment_login, container, false);

        final Switch switchLogin = rootView.findViewById(R.id.switch_login);
        switchLogin.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (switchLogin.isChecked())
                    switchLogin.setText(R.string.login_register_account);
                else
                    switchLogin.setText(R.string.login_existing_account);
            }
        });

        final EditText editTextUsername = rootView.findViewById(R.id.edit_text_login_name);

        if (paramUsername != null && !paramUsername.equals("")) {
            switchLogin.setChecked(false);
            switchLogin.setText(R.string.login_existing_account);
            editTextUsername.setText(paramUsername);
        } else {
            switchLogin.setChecked(true);
            switchLogin.setText(R.string.login_register_account);
            editTextUsername.setText("");
        }

        Button buttonLogin = rootView.findViewById(R.id.button_login);
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Button) v).setEnabled(false);
                String username = editTextUsername.getText().toString();
                String password = ((EditText) rootView.findViewById(R.id.edit_text_login_password)).getText().toString();
                boolean newUser = switchLogin.isChecked();
                TextView textViewLogin = rootView.findViewById(R.id.text_view_login);

                if (username.length() > 0 && password.length() > 0) {
                    textViewLogin.setText(getString(R.string.login_message_default));

                    DataAccessObject.loginUsername = username;
                    DataAccessObject.loginPassword = password;
                    DataAccessObject dataAccessObject = new DataAccessObject();
                    String response;

                    if (newUser) { // Register new user?
                        response = dataAccessObject.userRegister();

                        if (response != null) { // Ensure some type of response was received
                            if (response.startsWith(DataAccessObject.RESPONSE_MESSAGE_ERROR_PREFIX)) {
                                textViewLogin.setText(response);
                            } else { // User has been successfully registered
                                textViewLogin.setText("Registered... Logging In");
                                response = dataAccessObject.userLogin();

                                if (response != null) { // Received a token key, so store the username, grant user access to app
                                    if (context != null) {
                                        SharedPreferences sharedPreferences = context.getSharedPreferences(getString(R.string.app_name), Context.MODE_PRIVATE);
                                        SharedPreferences.Editor appStoredPrefsEditor = sharedPreferences.edit();
                                        appStoredPrefsEditor.putString(SHARED_PREFERENCES_USERNAME, DataAccessObject.loginUsername);
                                        appStoredPrefsEditor.apply();
                                    }
                                    MainActivity.loginFragment.dismiss();

                                } else { // Null returned from the network call
                                    textViewLogin.setText("Invalid Username or Password. Try again.");
                                }
                            }
                        } else { // Null returned from the network call
                            textViewLogin.setText("Unknown error. Already registered? Try again.");
                        }
                    } else { // Login existing user
                        textViewLogin.setText("Logging In");
                        response = dataAccessObject.userLogin();

                        if (response != null) { // Received a token key, so store the username, grant user access to app
                            if (context != null) {
                                SharedPreferences sharedPreferences = context.getSharedPreferences(getString(R.string.app_name), Context.MODE_PRIVATE);
                                SharedPreferences.Editor appStoredPrefsEditor = sharedPreferences.edit();
                                appStoredPrefsEditor.putString(SHARED_PREFERENCES_USERNAME, DataAccessObject.loginUsername);
                                appStoredPrefsEditor.apply();
                            }

                            MainActivity.loginFragment.dismiss();

                        } else { // Null returned from the network call
                            textViewLogin.setText("Invalid Username or Password. Try again.");
                        }
                    }
                } else { // User clicked Login button without typing anything into the EditText fields
                    textViewLogin.setText(getString(R.string.login_message_blank));
                }

                ((Button) v).setEnabled(true);
            }
        });

        return rootView;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(String username) {
        if (mListener != null) {
            mListener.onFragmentInteraction(username);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {

        void onFragmentInteraction(String username);
    }
}
