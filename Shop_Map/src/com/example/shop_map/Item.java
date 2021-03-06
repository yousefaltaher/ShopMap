package com.example.shop_map;
import android.os.Parcel;
import android.os.Parcelable;

public class Item implements Parcelable {
	
	String id = null;
	String name = null;
	boolean selected = false;

	public Item(Parcel input) {
		readFromParcel(input);
	}

	public Item(String id, String name, boolean selected) {
		super();
		this.id = id;
		this.name = name;
		this.selected = selected;
	}

	public String getID() {
		return id;
	}
	public void setCode(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public boolean isSelected() {
		return selected;
	}
	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {

		dest.writeString(name);
		dest.writeString(id);
		dest.writeByte((byte) (selected ? 1 : 0));

	}

	private void readFromParcel(Parcel input) {
		this.name=input.readString();
		this.id=input.readString();
		this.selected=input.readByte() == 1;
	}
	
	public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
		public Item createFromParcel(Parcel in){
			return new Item(in);
		}
		
		public Item[] newArray(int size){
			return new Item[size];
		}
	};

}
