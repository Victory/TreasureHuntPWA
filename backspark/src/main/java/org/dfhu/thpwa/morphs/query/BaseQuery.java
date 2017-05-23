package org.dfhu.thpwa.morphs.query;

import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;

public class BaseQuery {
  final Datastore datastore;

  BaseQuery(Datastore datastore) {
    this.datastore = datastore;
  }

  protected ObjectId toObjectId(String id) {
    return new ObjectId(id);
  }
}
