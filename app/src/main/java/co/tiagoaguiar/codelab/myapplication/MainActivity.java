package co.tiagoaguiar.codelab.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

	//private View btnImc;
	private RecyclerView rvMain;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		List<MainItem> mainItens = new ArrayList<>();
		mainItens.add(new MainItem(1,R.drawable.ic_baseline_wb_sunny_24, R.string.label_imc, R.color.colorPrimary));
		mainItens.add(new MainItem(2,R.drawable.ic_baseline_transfer_within_a_station_24, R.string.label_tmb, ContextCompat.getColor(this, R.color.colorAccent)));

		rvMain = findViewById(R.id.rv_main);
		rvMain.setLayoutManager(new GridLayoutManager(this,2));
//		rvMain.setLayoutManager(new LinearLayoutManager(this));

		MainAdapter adapter = new MainAdapter(mainItens);
		rvMain.setAdapter(adapter);


		/*btnImc = findViewById(R.id.btn_imc);

		btnImc.setOnClickListener(view -> {
			Intent it = new Intent(getBaseContext(), ImcActivity.class);
			startActivity(it);
		});*/
	}

	private class MainAdapter extends RecyclerView.Adapter<MainViewHolder> {

		private List<MainItem> mainItens = new ArrayList<>();

		public MainAdapter(List<MainItem> mainItems) {
			this.mainItens = mainItems;
		}

		@NonNull
		@Override
		public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
			return new MainViewHolder(getLayoutInflater().inflate(R.layout.main_item, parent, false));
		}

		@Override
		public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
			MainItem mainItemCurrent = mainItens.get(position);
			holder.bind(mainItemCurrent);
		}

		@Override
		public int getItemCount() {
			return mainItens.size();
		}
	}

	//View da célula que está dentro do RecyclerView
	private class MainViewHolder extends RecyclerView.ViewHolder {

		public MainViewHolder(@NonNull View itemView) {
			super(itemView);
		}

		public void bind(MainItem item) {
			LinearLayout container = (LinearLayout) itemView.findViewById(R.id.btn_imc);
			ImageView imgIcon = itemView.findViewById(R.id.item_img_icon);
			TextView txtName = itemView.findViewById(R.id.item_txt_name);

			container.setBackgroundColor(item.getCor());
			imgIcon.setImageResource(item.getDesenhavelId());
			txtName.setText(item.getTextStringId());
		}
	}
}