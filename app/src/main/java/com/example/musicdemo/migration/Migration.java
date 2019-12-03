package com.example.musicdemo.migration;

import io.realm.DynamicRealm;
import io.realm.RealmMigration;
import io.realm.RealmSchema;

public class Migration implements RealmMigration {

    @Override
    public void migrate(DynamicRealm realm, long oldVersion, long newVersion) {
//参数：动态realm对象（数据迁移时realm无法被打开），上一个数据库版本，最新数据库版本

//告诉数据库哪些数据库发生变化
        RealmSchema schema = realm.getSchema();

        /**
         * 第一次迁移
         */
        if (oldVersion == 0) {
//告诉数据库新建模型和增加字段
            schema.create("MusicModel")
                    .addField("musicId", String.class)
                    .addField("name", String.class)
                    .addField("poster", String.class)
                    .addField("path", String.class)
                    .addField("author", String.class);

            schema.create("AlbumModel")
                    .addField("albumId", String.class)
                    .addField("name", String.class)
                    .addField("poster", String.class)
                    .addField("playNum", String.class)
                    .addRealmListField("list", schema.get("MusicModel"));

            schema.create("MusicSourceModel")
                    .addRealmListField("album", schema.get("AlbumModel"))
                    .addRealmListField("hot", schema.get("MusicModel"));

            oldVersion = newVersion;
        }

    }
}
