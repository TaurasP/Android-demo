package lt.eif.viko.tpetrauskas.recyclerview_demo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class recyclerAdapter extends RecyclerView.Adapter<recyclerAdapter.MyViewHolder> {
    private ArrayList<User> usersList;

    public recyclerAdapter(ArrayList<User> usersList) {
        this.usersList = usersList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView nameTextView;
        private TextView lastNameTextView;

        public MyViewHolder(final View view) {
            super(view);
            nameTextView = view.findViewById(R.id.textViewNameValue);
            lastNameTextView = view.findViewById(R.id.textViewLastNameValue);
        }
    }


    @NonNull
    @Override
    public recyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_items, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull recyclerAdapter.MyViewHolder holder, int position) {
        String name = usersList.get(position).getName();
        String lastName = usersList.get(position).getLastName();
        holder.nameTextView.setText(name);
        holder.lastNameTextView.setText(lastName);
    }

    @Override
    public int getItemCount() {
        return usersList.size();
    }
}
