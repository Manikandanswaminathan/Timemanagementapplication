package timemanagementapplication.com;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

class CalenderAdapter extends RecyclerView.Adapter<CalenderViewHolder> {
    private final ArrayList<String> dayofmonth;
    private final OnItemListener onItemListener;

    public CalenderAdapter(ArrayList<String> dayofmonth, OnItemListener onItemListener) {
        this.dayofmonth = dayofmonth;
        this.onItemListener = onItemListener;
    }

    @NonNull
    @Override
    public CalenderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.calender_cell,parent,false);
        ViewGroup.LayoutParams layoutParams= view.getLayoutParams();
        layoutParams.height=(int) (parent.getHeight() * 0.1666666666);
        return new CalenderViewHolder(view, onItemListener);
    }

    @Override
    public void onBindViewHolder(@NonNull CalenderViewHolder holder, int position)
    {
        holder.dayOfMonth.setText(dayofmonth.get(position));

    }

    @Override
    public int getItemCount() {
        return dayofmonth.size();
    }

    public interface OnItemListener{
        void OnItemClick(int position, String dayText);

    }
}
