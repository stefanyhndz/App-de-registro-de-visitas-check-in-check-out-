package com.example.visitapp.data;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class VisitDao_Impl implements VisitDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Visit> __insertionAdapterOfVisit;

  private final EntityDeletionOrUpdateAdapter<Visit> __updateAdapterOfVisit;

  private final SharedSQLiteStatement __preparedStmtOfSetCheckOutTime;

  private final SharedSQLiteStatement __preparedStmtOfDeleteById;

  public VisitDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfVisit = new EntityInsertionAdapter<Visit>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `visits` (`id`,`checkInTime`,`checkOutTime`,`notes`) VALUES (nullif(?, 0),?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @Nullable final Visit entity) {
        statement.bindLong(1, entity.getId());
        statement.bindLong(2, entity.getCheckInTime());
        if (entity.getCheckOutTime() == null) {
          statement.bindNull(3);
        } else {
          statement.bindLong(3, entity.getCheckOutTime());
        }
        if (entity.getNotes() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getNotes());
        }
      }
    };
    this.__updateAdapterOfVisit = new EntityDeletionOrUpdateAdapter<Visit>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `visits` SET `id` = ?,`checkInTime` = ?,`checkOutTime` = ?,`notes` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @Nullable final Visit entity) {
        statement.bindLong(1, entity.getId());
        statement.bindLong(2, entity.getCheckInTime());
        if (entity.getCheckOutTime() == null) {
          statement.bindNull(3);
        } else {
          statement.bindLong(3, entity.getCheckOutTime());
        }
        if (entity.getNotes() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getNotes());
        }
        statement.bindLong(5, entity.getId());
      }
    };
    this.__preparedStmtOfSetCheckOutTime = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE visits SET checkOutTime = ? WHERE id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteById = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM visits WHERE id = ?";
        return _query;
      }
    };
  }

  @Override
  public Object insert(final Visit visit, final Continuation<? super Long> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      @NonNull
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          final Long _result = __insertionAdapterOfVisit.insertAndReturnId(visit);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object update(final Visit visit, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfVisit.handle(visit);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object setCheckOutTime(final long id, final long time,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfSetCheckOutTime.acquire();
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, time);
        _argIndex = 2;
        _stmt.bindLong(_argIndex, id);
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfSetCheckOutTime.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteById(final long id, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteById.acquire();
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, id);
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfDeleteById.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<Visit>> getAll() {
    final String _sql = "SELECT * FROM visits ORDER BY checkInTime DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"visits"}, new Callable<List<Visit>>() {
      @Override
      @NonNull
      public List<Visit> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfCheckInTime = CursorUtil.getColumnIndexOrThrow(_cursor, "checkInTime");
          final int _cursorIndexOfCheckOutTime = CursorUtil.getColumnIndexOrThrow(_cursor, "checkOutTime");
          final int _cursorIndexOfNotes = CursorUtil.getColumnIndexOrThrow(_cursor, "notes");
          final List<Visit> _result = new ArrayList<Visit>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Visit _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final long _tmpCheckInTime;
            _tmpCheckInTime = _cursor.getLong(_cursorIndexOfCheckInTime);
            final Long _tmpCheckOutTime;
            if (_cursor.isNull(_cursorIndexOfCheckOutTime)) {
              _tmpCheckOutTime = null;
            } else {
              _tmpCheckOutTime = _cursor.getLong(_cursorIndexOfCheckOutTime);
            }
            final String _tmpNotes;
            if (_cursor.isNull(_cursorIndexOfNotes)) {
              _tmpNotes = null;
            } else {
              _tmpNotes = _cursor.getString(_cursorIndexOfNotes);
            }
            _item = new Visit(_tmpId,_tmpCheckInTime,_tmpCheckOutTime,_tmpNotes);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Object getById(final long id, final Continuation<? super Visit> $completion) {
    final String _sql = "SELECT * FROM visits WHERE id = ? LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Visit>() {
      @Override
      @Nullable
      public Visit call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfCheckInTime = CursorUtil.getColumnIndexOrThrow(_cursor, "checkInTime");
          final int _cursorIndexOfCheckOutTime = CursorUtil.getColumnIndexOrThrow(_cursor, "checkOutTime");
          final int _cursorIndexOfNotes = CursorUtil.getColumnIndexOrThrow(_cursor, "notes");
          final Visit _result;
          if (_cursor.moveToFirst()) {
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final long _tmpCheckInTime;
            _tmpCheckInTime = _cursor.getLong(_cursorIndexOfCheckInTime);
            final Long _tmpCheckOutTime;
            if (_cursor.isNull(_cursorIndexOfCheckOutTime)) {
              _tmpCheckOutTime = null;
            } else {
              _tmpCheckOutTime = _cursor.getLong(_cursorIndexOfCheckOutTime);
            }
            final String _tmpNotes;
            if (_cursor.isNull(_cursorIndexOfNotes)) {
              _tmpNotes = null;
            } else {
              _tmpNotes = _cursor.getString(_cursorIndexOfNotes);
            }
            _result = new Visit(_tmpId,_tmpCheckInTime,_tmpCheckOutTime,_tmpNotes);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
