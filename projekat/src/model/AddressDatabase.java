package model;

import java.util.ArrayList;

public class AddressDatabase extends Address{

	private static ArrayList<Object> adrese=new ArrayList<>();
	private static int idA=1;

	public static void addAddress(Address a) {
		a.setAddressId(idA);
   	 	adrese.add(a);
   	 	idA++;
	}

	public static Address findByID(int id) {
		if (id==0) {
			return null;
		}
		for(Object it:adrese) {
			Address a=(Address) it;
			if (a.getAddressId()==id) {
				return a;
			}
		}
		return null;
	}

	public static void delAddress(int id) {
		id--;
		Address aCurr=new Address();
		Address aNew=new Address();
		for(int i=id+1;i<adrese.size();i++) {
			int aId=i+1;
			aCurr=findByID(aId);
			aNew=aCurr;
			aNew.setAddressId(aCurr.getAddressId()-1);
			adrese.set(i, aNew);
		}

		adrese.remove(id);
		idA--;
	}
}
