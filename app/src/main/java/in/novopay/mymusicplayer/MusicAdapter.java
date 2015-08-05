package in.novopay.mymusicplayer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.squareup.picasso.Picasso;

import java.lang.ref.WeakReference;
import java.util.List;


public class MusicAdapter extends BaseAdapter {
    WeakReference<Context> contextWeakReference;
    List<Music> musicList;

    public MusicAdapter(Context context, List<Music> musicList) {
        this.contextWeakReference = new WeakReference<Context>(context);
        this.musicList = musicList;
    }

    @Override
    public int getCount() {
        return musicList.size();
    }

    @Override
    public Music getItem(int position) {
        return musicList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private class ViewHolder {
        ImageView albumTextView;
        TextView artistTextView;
        TextView songTextView;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        ViewHolder viewHolder = null;

        if (convertView == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(contextWeakReference.get());
            view = layoutInflater.inflate(R.layout.item_music, parent, false);

            viewHolder = new ViewHolder();

            viewHolder.albumTextView = (ImageView) view.findViewById(R.id.item_music_album);
            viewHolder.artistTextView = (TextView) view.findViewById(R.id.item_music_artist);
            viewHolder.songTextView = (TextView) view.findViewById(R.id.item_music_song);

            view.setTag(viewHolder);
        }

        if (viewHolder == null) {
            viewHolder = (ViewHolder) view.getTag();
        }

        Music music = getItem(position);

        Picasso
                .with(contextWeakReference.get())
                .load("http://www.keenthemes.com/preview/metronic/theme/assets/global/plugins/jcrop/demos/demo_files/image1.jpg")
                .into(viewHolder.albumTextView);
        viewHolder.artistTextView.setText(music.getArtistName());
        viewHolder.songTextView.setText(music.getSongName());

        return view;
    }
}