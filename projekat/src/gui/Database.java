package gui;

import java.util.ArrayList;
import java.util.List;

import enums.SemesterEnum;
import enums.StatusEnum;
import enums.TitleEnum;
import manageEntities.CheckValidity;
import manageEntities.professor.ProfessorDatabase;
import manageEntities.student.StudentDatabase;
import manageEntities.subject.SubjectDatabase;
import model.Address;
import model.AddressDatabase;
import model.Grade;
import model.Professor;
import model.Student;
import model.Subject;

public class Database {

	public static void insertValues() {
		Address a1=new Address("Šafarikova","2","Novi Sad","Srbija");
		Address a2=new Address("Nikole Tesle","56","Novi Sad","Srbija");
		Address a3=new Address("Bulevar Patrijaha Pavla","3","Beograd","Srbija");
		Address a4=new Address("Stražilovska","6a","Novi Sad","Srbija");
		Address a5=new Address("Nikole Pašića","2d","Kikinda","Srbija");
		Address a6=new Address("Bulevar Kralja Petra","22","Niš","Srbija");
		Address a7=new Address("Tolstojeva","31","Novi Sad","Srbija");
		Address a8=new Address("Marićeva","11","Kragujevac","Srbija");
		Address a9=new Address("Stražilovska","3","Beograd","Srbija");
		Address a10=new Address("Nikole Pašića","6a","Novi Sad","Srbija");
		Address a11=new Address("Bulevar Kralja Petra","2d","Niš","Srbija");
		Address a12=new Address("Knez Mihajlova","22","Beograd","Srbija");

		AddressDatabase.addAddress(a1);
		AddressDatabase.addAddress(a2);
		AddressDatabase.addAddress(a3);
		AddressDatabase.addAddress(a4);
		AddressDatabase.addAddress(a5);
		AddressDatabase.addAddress(a6);
		AddressDatabase.addAddress(a7);
		AddressDatabase.addAddress(a8);
		AddressDatabase.addAddress(a9);
		AddressDatabase.addAddress(a10);
		AddressDatabase.addAddress(a11);
		AddressDatabase.addAddress(a12);

		//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
		Student s1=new Student("Milosevic","Marko",CheckValidity.formatDate("12.03.2001."),1,"021/333-555","marko.milosevic@mailinator.com","RA 2/2020",2020,1,StatusEnum.BUDGET);
		Student s2=new Student("Milić","Marija",CheckValidity.formatDate("12.01.2000."),2,"021/555-2222","marija.milic@mailinator.com","RA 3/2019",2019,2,StatusEnum.SELF_FINANCING);
		Student s3=new Student("Nikolic","Nikola",CheckValidity.formatDate("30.08.2001."),3,"021/135-463","nikola.nikolic@mailinator.com","RA 3/2017",2017,1,StatusEnum.BUDGET);
		Student s4=new Student("Peric","Pera",CheckValidity.formatDate("07.06.1995."),4,"021/903-463","pera.peric@mailinator.com","RA 134/2015",2015,3,StatusEnum.SELF_FINANCING);
		Student s5=new Student("Ilic","Sofija",CheckValidity.formatDate("06.05.1999."),5,"021/731-067","sofija.ilic@mailinator.com","RA 5/2019",2019,3,StatusEnum.BUDGET);
		Student s6=new Student("Lukic","Martina",CheckValidity.formatDate("16.05.1999."),6,"011/4333-800","martina.lukic@mailinator.com","RA 8/2018",2018,3,StatusEnum.SELF_FINANCING);
		Student s7=new Student("Stojakovic","Stojan",CheckValidity.formatDate("19.10.2001."),7,"011/3130-007","stojan.stojakovic@mailinator.com","RA 10/2017",2017,1,StatusEnum.BUDGET);
		Student s8=new Student("Milanovic","Milan",CheckValidity.formatDate("02.11.2000."),8,"015/313-061","milan.milanovic@mailinator.com","RA 12/2017",2017,2,StatusEnum.SELF_FINANCING);
		Student s9=new Student("Milic","Miroslav",CheckValidity.formatDate("11.10.2000."),9,"021/351-091","miroslav.milic@mailinator.com","RA 16/2019",2019,2,StatusEnum.BUDGET);
		Student s10=new Student("Gojic","Stefan",CheckValidity.formatDate("01.05.1999."),10,"015/324-500","stefan.gojic@mailinator.com","RA 21/2015",2015,3,StatusEnum.SELF_FINANCING);
		Student s11=new Student("Jokic","Anastasija",CheckValidity.formatDate("11.07.1999."),11,"011/2333-900","anastasija.jokic@mailinator.com","RA 9/2020",2020,3,StatusEnum.BUDGET);
		Student s12=new Student("Bogdanovic","Bogdan",CheckValidity.formatDate("23.07.1999."),12,"021/231-231","bogdan.bogdanovic@mailinator.com","RA 4/2017",2017,3,StatusEnum.SELF_FINANCING);
		Student s13=new Student("Dabovic","Ana",CheckValidity.formatDate("12.12.2001."),0,"014/303-007","ana.dabovic@mailinator.com","RA 30/2019",2019,1,StatusEnum.BUDGET);
		Student s14=new Student("Mikic","Mika",CheckValidity.formatDate("05.11.2001."),2,"015/101-909","mika.mikic@mailinator.com","RA 1/2020",2020,1,StatusEnum.SELF_FINANCING);
		Student s15=new Student("Deretic","Jovan",CheckValidity.formatDate("10.09.1998."),3,"002/200-300","jovan.deretic@mailinator.com","RA 11/2018",2018,4,StatusEnum.BUDGET);
		Student s16=new Student("Miskovic","Nikola",CheckValidity.formatDate("03.08.1998."),4,"022/123-456","nikola.miskovic@mailinator.com","RA 12/2018",2018,4,StatusEnum.SELF_FINANCING);
		Student s17=new Student("Stojanovic","Martin",CheckValidity.formatDate("01.05.1998."),0,"024/321-775","martin.stojanovic@mailinator.com","RA 13/2018",2018,4,StatusEnum.SELF_FINANCING);
		Student s18=new Student("Novakovic","Tomislav",CheckValidity.formatDate("25.02.1996."),6,"011/1188-379","tomislav.novakovic@mailinator.com","RA 14/2018",2018,4,StatusEnum.BUDGET);
		Student s19=new Student("Ivic","Lena",CheckValidity.formatDate("11.05.1998."),7,"024/333-555","lena.ivic@mailinator.com","RA 154/2016",2016,4,StatusEnum.BUDGET);
		Student s20=new Student("Lazic","Jovan",CheckValidity.formatDate("22.01.2001."),8,"025/1189-479","jovan.lazic@mailinator.com","RA 23/2020",2020,1,StatusEnum.BUDGET);
		Student s21=new Student("Mikic","Isidora",CheckValidity.formatDate("31.12.2000."),9,"011/1122-366","isidora.mikic@mailinator.com","RA 1/2019",2019,2,StatusEnum.BUDGET);
		Student s22=new Student("Ilic","Vladimir",CheckValidity.formatDate("31.08.1998."),10,"021/1122-367","vladimir.ilic@mailinator.com","SW 4/2014",2014,4,StatusEnum.BUDGET);
		Student s23=new Student("Alicic","Mirko",CheckValidity.formatDate("21.07.1999."),11,"012/1122-368","mirko.alicic@mailinator.com","SW 17/2015",2015,3,StatusEnum.SELF_FINANCING);
		Student s24=new Student("Perković","Milisav",CheckValidity.formatDate("28.09.1998."),12,"012/1122-369","milisav.pejkovic@mailinator.com","SW 17/2016",2016,4,StatusEnum.SELF_FINANCING);
		Student s25=new Student("Djordjević","Purisa",CheckValidity.formatDate("29.02.2000."),3,"011/1543-370","purisa.djordjevic@mailinator.com","SW 27/2018",2018,2,StatusEnum.BUDGET);
		Student s26=new Student("Kovacević","Mikica",CheckValidity.formatDate("23.03.1999."),5,"011/1992-371","mikica.kovacevic@mailinator.com","RA 226/2017",2017,3,StatusEnum.SELF_FINANCING);
		Student s27=new Student("Milić","Miloš",CheckValidity.formatDate("21.10.2001."),2,"011/8172-372","milos.milic@mailinator.com","SW 12/2021",2021,1,StatusEnum.SELF_FINANCING);


		ArrayList<Object> students=new ArrayList<>(List.of(s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11,s12,s13,s14,s15,s16,s17,s18,s19,s20,s21,s22,s23,s24,s25,s26,s27));
		StudentDatabase.addStudents(students);

		//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

		Professor p1=new Professor(123123123,"Nikolic","Milos",CheckValidity.formatDate("12.12.1965."),1,"021/356-785","milos.nikolic@mailinator.com",10,TitleEnum.REDOVNI_PROFESOR,30);
		Professor p2=new Professor(321321321,"Mirkovic","Nikola",CheckValidity.formatDate("01.01.1978."),2,"021/368-456","nikola.mirkovic@mailinator.com",10,TitleEnum.REDOVNI_PROFESOR,22);
		Professor p3=new Professor(456456456,"Petkovic","Ilija",CheckValidity.formatDate("03.09.1988."),3,"021/215-314","ilija.petkovic@mailinator.com",10,TitleEnum.VANREDNI_PROFESOR,22);
		Professor p4=new Professor(789789789,"Petrovic","Mitar",CheckValidity.formatDate("25.07.1976."),4,"021/884-640","mitar.petrovic@mailinator.com",10,TitleEnum.VANREDNI_PROFESOR,27);
		Professor p5=new Professor(100100144,"Micic","Vasa",CheckValidity.formatDate("14.02.1970."),5,"021/212-114","vasa.micic@mailinator.com",10,TitleEnum.DOCENT,24);
		Professor p6=new Professor(200020244,"Miletic","Srdjan",CheckValidity.formatDate("20.04.1966."),6,"021/978-225","srdjan.miletic@mailinator.com",10,TitleEnum.DOCENT,31);
		Professor p7=new Professor(559585632,"Mihajlovic","Branislav",CheckValidity.formatDate("28.06.1980."),7,"021/778-323","branislav.mihajlovic@mailinator.com",10,TitleEnum.REDOVNI_PROFESOR,13);
		Professor p8=new Professor(334968855,"Marković","Marko",CheckValidity.formatDate("31.01.1985."),8,"021/899-659","marko.markovic@mailinator.com",10,TitleEnum.REDOVNI_PROFESOR,17);
		Professor p9=new Professor(730703654,"Milaković","Miloš",CheckValidity.formatDate("21.09.1975."),9,"021/122-326","milos.milakovic@mailinator.com",10,TitleEnum.VANREDNI_PROFESOR,12);
		Professor p10=new Professor(600378644,"Bratić","Lazar",CheckValidity.formatDate("13.11.1973."),10,"021/156-326","lazar.bratic@mailinator.com",10,TitleEnum.VANREDNI_PROFESOR,3);
		Professor p11=new Professor(158496152,"Dražić","Ljeposava",CheckValidity.formatDate("11.08.1964."),11,"021/888-156","ljeposava.drazic@mailinator.com",10,TitleEnum.DOCENT,31);
		Professor p12=new Professor(777348595,"Dragić","Miroljub",CheckValidity.formatDate("02.03.1959."),12,"021/456-125","miroljub.dragic@mailinator.com",10,TitleEnum.DOCENT,42);
		Professor p13=new Professor(721254363,"Rekavić","Bogdan",CheckValidity.formatDate("23.06.1977."),6,"021/886-455","bogdan.rekavic@mailinator.com",10,TitleEnum.VANREDNI_PROFESOR,18);
		Professor p14=new Professor(225533448,"Milić","Stanka",CheckValidity.formatDate("03.03.1991."),3,"021/945-155","stanka.milic@mailinator.com",10,TitleEnum.DOCENT,7);
		Professor p15=new Professor(111555888,"Vuković","Milica",CheckValidity.formatDate("18.10.1967."),8,"021/746-659","milica.vukovic@mailinator.com",10,TitleEnum.VANREDNI_PROFESOR,14);
		Professor p16=new Professor(300300344,"Mišić","Miša",CheckValidity.formatDate("20.10.1969."),1,"021/489-326","misa.misic@mailinator.com",10,TitleEnum.DOCENT,19);
		Professor p17=new Professor(400400444,"Maricić","Branko",CheckValidity.formatDate("18.01.1973."),2,"021/487-265","branko.maricic@mailinator.com",10,TitleEnum.DOCENT,22);
		Professor p18=new Professor(500500544,"Lukovic","Branislav",CheckValidity.formatDate("08.04.1982."),3,"021/159-478","branislav.lukovic@mailinator.com",10,TitleEnum.REDOVNI_PROFESOR,9);
		Professor p19=new Professor(600600644,"Obradović","Branimir",CheckValidity.formatDate("07.01.1979."),1,"021/922-333","branimir.obradovic@mailinator.com",10,TitleEnum.DOCENT,17);

		ArrayList<Object> professors=new ArrayList<>(List.of(p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12,p13,p14,p15,p16,p17,p18,p19));
		ProfessorDatabase.addProfessors(professors);
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

		Subject subj1=new Subject("p1","osnove programiranja",SemesterEnum.WINTER,1,2,7);
		Subject subj2=new Subject("p2","statistika",SemesterEnum.SUMMER,3,2,8);
		Subject subj3=new Subject("p3","algoritmi i strukture podataka",SemesterEnum.SUMMER,2,2,9);
		Subject subj4=new Subject("p4","LPRS",SemesterEnum.WINTER,3,2,7);
		Subject subj5=new Subject("p5","matematika",SemesterEnum.SUMMER,1,0,11);
		Subject subj6=new Subject("p6","xml i web servisi",SemesterEnum.SUMMER,4,0,6);
		Subject subj7=new Subject("p7","Metode optimizacije",SemesterEnum.WINTER,3,0,6);
		Subject subj8=new Subject("p8","osnove elektortehnike",SemesterEnum.SUMMER,1,5,11);
		Subject subj9=new Subject("p9","Sociologija",SemesterEnum.WINTER,1,5,10);
		Subject subj10=new Subject("p10","Filozofija",SemesterEnum.WINTER,1,5,4);
		Subject subj11=new Subject("p11","ORT",SemesterEnum.SUMMER,2,0,7);
		Subject subj12=new Subject("p12","NANS",SemesterEnum.SUMMER,2,6,5);
		Subject subj13=new Subject("p13","Organizacija podataka",SemesterEnum.WINTER,2,6,7);
		Subject subj14=new Subject("p14","Baze podataka",SemesterEnum.WINTER,2,6,6);
		Subject subj15=new Subject("p15","paralelno programiranje",SemesterEnum.WINTER,2,7,8);
		Subject subj16=new Subject("p16","konkurentno programiranje",SemesterEnum.SUMMER,2,7,9);
		Subject subj17=new Subject("p17","Operativni sistemi",SemesterEnum.SUMMER,2,0,8);
		Subject subj18=new Subject("p18","Algebra",SemesterEnum.WINTER,1,0,15);
		Subject subj19=new Subject("p19","Diskretna matematika",SemesterEnum.SUMMER,3,0,14);
		Subject subj20=new Subject("ps20","Upravljacki sistemi",SemesterEnum.SUMMER,3,0,8);
		Subject subj21=new Subject("ps21","Osnovi elektronike",SemesterEnum.WINTER,2,0,7);
		Subject subj22=new Subject("ps22","Slucajni procesi",SemesterEnum.SUMMER,4,0,9);
		Subject subj23=new Subject("ps23","Racunarstvo visokih performansi",SemesterEnum.SUMMER,4,0,10);
		Subject subj24=new Subject("p24","Analiza 1",SemesterEnum.WINTER,1,0,20);
		Subject subj25=new Subject("it25","Informaciona bezbednost",SemesterEnum.SUMMER,4,17,9);
		Subject subj26=new Subject("it26","Elektronsko placanje",SemesterEnum.WINTER,3,18,8);
		Subject subj27=new Subject("it27","Distribuirani sistemi",SemesterEnum.SUMMER,4,19,6);
		Subject subj28=new Subject("p28","Projektovanje softvera",SemesterEnum.WINTER,3,18,5);
		Subject subj29=new Subject("p29","Informacioni sistemi",SemesterEnum.WINTER,4,17,6);
		Subject subj30=new Subject("p30","Masinsko ucenje",SemesterEnum.SUMMER,4,0,7);
		ArrayList<Object> subjects=new ArrayList<>(List.of(subj1,subj2,subj3,subj4,subj5,subj6,subj7,subj8,subj9,subj10,subj11,subj12,subj13,subj14,subj15,subj16,subj17,subj18,subj19,subj20,subj21,subj22,subj23,subj24,subj25,subj26,subj27,subj28,subj29,subj30));
		SubjectDatabase.addSubjects(subjects);
		SubjectDatabase.printSubjects();
		SubjectDatabase.initList();


		//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

		Grade g1=new Grade(StudentDatabase.findByID(4),SubjectDatabase.findByID(5),10,CheckValidity.formatDate("12.12.2017."));
		Grade g2=new Grade(StudentDatabase.findByID(4),SubjectDatabase.findByID(3),9,CheckValidity.formatDate("10.11.2019."));
		Grade g3=new Grade(StudentDatabase.findByID(4),SubjectDatabase.findByID(1),8,CheckValidity.formatDate("11.11.2020.."));
		Grade g4=new Grade(StudentDatabase.findByID(2),SubjectDatabase.findByID(1),10,CheckValidity.formatDate("20.11.2020."));
		Grade g5=new Grade(StudentDatabase.findByID(2),SubjectDatabase.findByID(5),10,CheckValidity.formatDate("30.10.2021."));
		Grade g6=new Grade(StudentDatabase.findByID(15),SubjectDatabase.findByID(15),7,CheckValidity.formatDate("10.01.2021."));
		Grade g7=new Grade(StudentDatabase.findByID(16),SubjectDatabase.findByID(15),10,CheckValidity.formatDate("12.01.2018."));
		Grade g8=new Grade(StudentDatabase.findByID(15),SubjectDatabase.findByID(16),10,CheckValidity.formatDate("01.01.2021."));
		Grade g9=new Grade(StudentDatabase.findByID(16),SubjectDatabase.findByID(16),9,CheckValidity.formatDate("04.02.2019."));

		Grade g10=new Grade(StudentDatabase.findByID(4),SubjectDatabase.findByID(2));
		Grade g11=new Grade(StudentDatabase.findByID(4),SubjectDatabase.findByID(4));
		Grade g12=new Grade(StudentDatabase.findByID(17),SubjectDatabase.findByID(15));
		Grade g13=new Grade(StudentDatabase.findByID(18),SubjectDatabase.findByID(15));
		Grade g14=new Grade(StudentDatabase.findByID(22),SubjectDatabase.findByID(18));
		Grade g15=new Grade(StudentDatabase.findByID(23),SubjectDatabase.findByID(18));
		Grade g16=new Grade(StudentDatabase.findByID(24),SubjectDatabase.findByID(18));
		Grade g17=new Grade(StudentDatabase.findByID(26),SubjectDatabase.findByID(18));
		Grade g18=new Grade(StudentDatabase.findByID(22),SubjectDatabase.findByID(19));
		Grade g19=new Grade(StudentDatabase.findByID(23),SubjectDatabase.findByID(19));
		Grade g20=new Grade(StudentDatabase.findByID(24),SubjectDatabase.findByID(19));
		Grade g21=new Grade(StudentDatabase.findByID(26),SubjectDatabase.findByID(19));

		ArrayList<Grade> gradesPassed=new ArrayList<>(List.of(g1,g2,g3,g4,g5,g6,g7,g8,g9));
		ArrayList<Grade> gradesFailed=new ArrayList<>(List.of(g10,g11,g12,g13,g14,g15,g16,g17,g18,g19,g20,g21));
		Grade.assignPassedGrades(gradesPassed);
		Grade.assignFailedGrades(gradesFailed);


	}
}
