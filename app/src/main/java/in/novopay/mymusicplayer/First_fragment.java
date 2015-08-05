package in.novopay.mymusicplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * Created by rohitshukla on 8/4/15.
 */


public class First_fragment extends Fragment {
    private ListView listView;

    private ArrayList<Music> musicList = new ArrayList<>();
    private MusicAdapter musicAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        musicList.add(new Music("alphaSongName0", "alphaAlbum", "alphaArtist"));
        musicList.add(new Music("alphaSongName1", "alphaAlbum", "alphaArtist"));
        musicList.add(new Music("alphaSongName2", "alphaAlbum", "alphaArtist"));
        musicList.add(new Music("alphaSongName3", "alphaAlbum", "alphaArtist"));
        musicList.add(new Music("alphaSongName0", "alphaAlbum", "alphaArtist"));
        musicList.add(new Music("alphaSongName1", "alphaAlbum", "alphaArtist"));
        musicList.add(new Music("alphaSongName2", "alphaAlbum", "alphaArtist"));
        musicList.add(new Music("alphaSongName3", "alphaAlbum", "alphaArtist"));
        musicList.add(new Music("alphaSongName0", "alphaAlbum", "alphaArtist"));
        musicList.add(new Music("alphaSongName1", "alphaAlbum", "alphaArtist"));
        musicList.add(new Music("alphaSongName2", "alphaAlbum", "alphaArtist"));
        musicList.add(new Music("alphaSongName3", "alphaAlbum", "alphaArtist"));
        musicList.add(new Music("alphaSongName0", "alphaAlbum", "alphaArtist"));
        musicList.add(new Music("alphaSongName1", "alphaAlbum", "alphaArtist"));
        musicList.add(new Music("alphaSongName2", "alphaAlbum", "alphaArtist"));
        musicList.add(new Music("alphaSongName3", "alphaAlbum", "alphaArtist"));
        musicList.add(new Music("alphaSongName0", "alphaAlbum", "alphaArtist"));
        musicList.add(new Music("alphaSongName1", "alphaAlbum", "alphaArtist"));
        musicList.add(new Music("alphaSongName2", "alphaAlbum", "alphaArtist"));
        musicList.add(new Music("alphaSongName3", "alphaAlbum", "alphaArtist"));
        musicList.add(new Music("alphaSongName0", "alphaAlbum", "alphaArtist"));
        musicList.add(new Music("alphaSongName1", "alphaAlbum", "alphaArtist"));
        musicList.add(new Music("alphaSongName2", "alphaAlbum", "alphaArtist"));
        musicList.add(new Music("alphaSongName3", "alphaAlbum", "alphaArtist"));
        musicList.add(new Music("alphaSongName0", "alphaAlbum", "alphaArtist"));
        musicList.add(new Music("alphaSongName1", "alphaAlbum", "alphaArtist"));
        musicList.add(new Music("alphaSongName2", "alphaAlbum", "alphaArtist"));
        musicList.add(new Music("alphaSongName3", "alphaAlbum", "alphaArtist"));
        musicList.add(new Music("alphaSongName0", "alphaAlbum", "alphaArtist"));
        musicList.add(new Music("alphaSongName1", "alphaAlbum", "alphaArtist"));
        musicList.add(new Music("alphaSongName2", "alphaAlbum", "alphaArtist"));
        musicList.add(new Music("alphaSongName3", "alphaAlbum", "alphaArtist"));
        musicList.add(new Music("alphaSongName0", "alphaAlbum", "alphaArtist"));
        musicList.add(new Music("alphaSongName1", "alphaAlbum", "alphaArtist"));
        musicList.add(new Music("alphaSongName2", "alphaAlbum", "alphaArtist"));
        musicList.add(new Music("alphaSongName3", "alphaAlbum", "alphaArtist"));
        musicList.add(new Music("alphaSongName0", "alphaAlbum", "alphaArtist"));
        musicList.add(new Music("alphaSongName1", "alphaAlbum", "alphaArtist"));
        musicList.add(new Music("alphaSongName2", "alphaAlbum", "alphaArtist"));
        musicList.add(new Music("alphaSongName3", "alphaAlbum", "alphaArtist"));
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        listView = (ListView) view.findViewById(R.id.fragment_list_view);

        musicAdapter = new MusicAdapter(getActivity(), musicList);
        listView.setAdapter(musicAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                Intent i=new Intent(getActivity(), MainActivity.class);
                startActivity(i);




            }
        });


        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
