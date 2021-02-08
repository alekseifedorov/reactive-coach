package com.my.couchbase.example.service.inventory.migration;

import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.manager.query.CreatePrimaryQueryIndexOptions;
import com.github.couchversion.changeset.ChangeLog;
import com.github.couchversion.changeset.ChangeSet;
import org.springframework.stereotype.Component;

@Component
@ChangeLog(order = "001")
public class InventoryMigration {

    @ChangeSet(order = "001", id = "001", author = "")
    public void firstChangeSet(Cluster cluster, Bucket bucket) {
        cluster.queryIndexes().createPrimaryIndex(bucket.name(),
            CreatePrimaryQueryIndexOptions.createPrimaryQueryIndexOptions().ignoreIfExists(true));
    }
}