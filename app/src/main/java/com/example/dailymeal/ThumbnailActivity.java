package com.example.dailymeal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.dailymeal_Classes.AlertDialogue;
import com.example.dailymeal_Classes.DummyData;
import com.example.dailymeal_Classes.Items;

import java.util.ArrayList;

public class ThumbnailActivity extends BaseActivity {
    LinearLayout parentLayout, pr;
    int id;
    String category;
    ArrayList<Items> items;
    ArrayList<Items> new_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.addContentView(R.layout.activity_thumbnail);
        super.setItemChecked(R.id.nav_category);

        try {
            parentLayout = findViewById(R.id.layout_table_thumbnails);
            pr = findViewById(R.id.p);

            Bundle bundle = getIntent().getExtras();
            category = bundle.getString("category");
            ((TextView)findViewById(R.id.txt_category_header)).setText(category);

            items = DummyData.getItems();
            new_list = getNewList();
            createLayout();

//            LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//            View contentView = inflater.inflate(R.layout.activity_thumbnail, null, false);
////            pr.addView(contentView);

        } catch (Exception e) {
            (new AlertDialogue(this)).printMsg(e);
        }
    }

    private void createLayout() {
        LinearLayout.LayoutParams my_param = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);

        int sizeOfLoop = (int) Math.ceil(new_list.size() / 2.0);

        int index = 0;
        for (int i = 0; i < sizeOfLoop; i++) {
            LinearLayout mylayout = new LinearLayout(this);
            mylayout.setLayoutParams(my_param);
            mylayout.setOrientation(LinearLayout.HORIZONTAL);
            mylayout.setId(View.generateViewId());
            mylayout.setPadding(10, 10, 10, 10);
            if (new_list.size() % 2 == 0) {
                mylayout.addView(createImageView(index));
                mylayout.addView(createImageView(++index));
                index++;
            } else {
                if ((i + 1) == sizeOfLoop) {
                    mylayout.addView(createImageView(index));
                } else {
                    mylayout.addView(createImageView(index));
                    mylayout.addView(createImageView(++index));
                    index++;
                }
            }
            parentLayout.addView(mylayout);
            parentLayout.invalidate();
        }
    }

    private ImageView createImageView(int in) {
        Items item = new_list.get(in);
        LinearLayout.LayoutParams img_param = new LinearLayout.LayoutParams(
                0,
                250, 1);
        ImageView imageView = new ImageView(this);
        imageView.setLayoutParams(img_param);
        imageView.setImageResource(item.getDrawable_id());
        imageView.setPadding(5,5,5,5);
        imageView.setTag(item.getId());
        imageView.setId(View.generateViewId());
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDetailActivity(view);
            }
        });

        return imageView;
    }

    public void openDetailActivity(View view) {
        AlertDialogue alert = (new AlertDialogue(this));

        try {
            ImageView imageView = findViewById(view.getId());
            String imageName = imageView.getTag().toString();
            int id = this.getResources().getIdentifier(imageName, "drawable", this.getPackageName());

            Intent intent = new Intent(this, ItemDetailActivity.class);
            intent.putExtra("id", id);
            startActivity(intent);
        } catch (Exception e) {
            alert.printMsg(e);
        }
    }


    private ArrayList<Items> getNewList() {
        ArrayList<Items> list = new ArrayList<>();
        for (Items i : items) {
            if (i.getCategory().equalsIgnoreCase(category)) {
                list.add(i);
            }
        }
        return list;
    }
}
