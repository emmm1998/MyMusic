package com.example.musicdemo.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.musicdemo.R;
import com.example.musicdemo.adapter.MusicListAdapter;
import com.example.musicdemo.helps.RealmHelper;
import com.example.musicdemo.models.AlbumModel;

public class AlbumListActivity extends BaseActivity {

    public static final String ALBUM_ID ="albumId";
    private RecyclerView mRvList;
    private MusicListAdapter mAdapter;
    private String mAlbumId;
    private RealmHelper mRealmHelper;
    private AlbumModel mAlbumModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album_list);
        initData();
        initView();
    }

    private void initData(){
        mAlbumId=getIntent().getStringExtra(ALBUM_ID);
        mRealmHelper=new RealmHelper();
        mAlbumModel=mRealmHelper.getAlbum(mAlbumId);
    }

    private void initView(){
        initNavBar(true,"专辑列表",false);
        mRvList=fd(R.id.rv_list);
        mRvList.setLayoutManager(new LinearLayoutManager(this));
        mRvList.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        mAdapter=new MusicListAdapter(this,null,mAlbumModel.getList());
        mRvList.setAdapter(mAdapter);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        mRealmHelper.close();
    }
}
