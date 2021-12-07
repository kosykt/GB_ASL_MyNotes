package ru.kostrykt.gb_asl_mynotes.notes;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Objects;

@Entity
public class MyNote implements Parcelable {

    public static final Creator<MyNote> CREATOR = new Creator<MyNote>() {
        @Override
        public MyNote createFromParcel(Parcel in) {
            return new MyNote(in);
        }

        @Override
        public MyNote[] newArray(int size) {
            return new MyNote[size];
        }
    };
    @PrimaryKey(autoGenerate = true)
    public int uniqueId;

    @ColumnInfo(name = "noteText")
    public String noteText;

    @ColumnInfo(name = "noteTime")
    public long noteTime;

    @ColumnInfo(name = "noteIsDone")
    public boolean noteIsDone;

    public MyNote() {
    }

    protected MyNote(Parcel in) {
        uniqueId = in.readInt();
        noteText = in.readString();
        noteTime = in.readLong();
        noteIsDone = in.readByte() != 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyNote myNote = (MyNote) o;
        return uniqueId == myNote.uniqueId &&
                noteTime == myNote.noteTime &&
                noteIsDone == myNote.noteIsDone &&
                Objects.equals(noteText, myNote.noteText);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uniqueId, noteText, noteTime, noteIsDone);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(uniqueId);
        dest.writeString(noteText);
        dest.writeLong(noteTime);
        dest.writeByte((byte) (noteIsDone ? 1 : 0));
    }
}
