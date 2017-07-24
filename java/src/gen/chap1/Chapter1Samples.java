package gen.chap1;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Chapter1Samples {
	private File source = new File("lipsum25para.txt");
	public static void main(String[] args){
//		System.out.println("####################");
//		System.out.println("Section 1.1");
//		section1();
//		System.out.println("####################");
//		System.out.println("Section 1.2");
//		section2();
//		System.out.println("####################");
//		System.out.println("Section 1.5");
//		section5();
//		System.out.println("####################");
//		System.out.println("Section 1.6");
//		section6();
//		System.out.println("####################");
//		System.out.println("Section 1.7");
//		section7();
		System.out.println("####################");
		System.out.println("Section 1.8");
		section8();
	}
	
	public static void section1(){
		try {
			String contents = new String(Files.readAllBytes(Paths.get("lipsum25para.txt")),StandardCharsets.UTF_8);
			List<String> words = Arrays.asList(contents.split("\\PL+"));
			System.out.println(words.size());
			//for loop version
			long count = 0;
			for(String s : words){
				if(s.length()>10){
					count++;
				}
			}
			System.out.println("Number of words longer than 10 (for loop ver): " + count);
			
			//stream version
			long countStream = words.stream().filter(s->s.length()>10).count();
			System.out.println("Number of words longer than 10 (stream ver): " + countStream);
			
			//parallel version
			long countParallel = words.parallelStream().filter(s->s.length()>10).count();
			System.out.println("Number of words longer than 10 (parallel ver): " + countParallel);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}		
	}
	
	public static void section2(){
		try {
			String contents = new String(Files.readAllBytes(Paths.get("lipsum25para.txt")),StandardCharsets.UTF_8);
			Stream<String> words = Stream.of(contents.split("\\PL+"));
			System.out.println(words.count());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		Stream<String> song = Stream.of("gently","down","the","stream");
		System.out.println("Song count of Stream from array: "+ song.count());
		
		Stream<String> emptyStream = Stream.empty();
		
		//WARNING: This will create an infinite loop
		Stream<String> echos = Stream.generate(()->"Echo");
		show("echos",echos);
		Stream<Double> randoms = Stream.generate(Math::random);
		show("randoms",randoms);
	}
	
	public static void section3(){
		try {
			String contents = new String(Files.readAllBytes(Paths.get("lipsum25para.txt")),StandardCharsets.UTF_8);
			List<String> words = Arrays.asList(contents.split("\\PL+"));
			Stream<String>longWords = words.stream().filter(w -> w.length()>10);
			Stream<String>lowerCase = words.stream().map(String::toLowerCase);
			Stream<String>firstLetter = words.stream().map(w->w.substring(0, 1));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}		
	}
	
	public static void section5(){
		try {
			String contents = new String(Files.readAllBytes(Paths.get("lipsum25para.txt")),StandardCharsets.UTF_8);
			List<String> words = Arrays.asList(contents.split("\\PL+"));
			Stream<String> uniques = words.stream().distinct();
			System.out.println("Unique word count: "+uniques.count());
			Stream<String> uniqueLong = words.stream().distinct().filter(w -> w.length()>10);
			System.out.println("Unique long word count: "+uniqueLong.count());
			//Object[] temp = Stream.iterate(1.0,p -> p*2).peek(e -> System.out.println("Fetching "+ e)).limit(20).toArray();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}		
	}
	
	public static void section6(){
		Stream<String> words = buildList();
		Optional<String> largest = words.max(String::compareToIgnoreCase);
		System.out.println("Largest: "+largest.orElse(""));
	}
	
	public static void section7(){
		Stream<String> words = buildList();
		Optional<String> optionalString = words.filter(s -> s.startsWith("Q")).findFirst();
		String temp = optionalString.orElse("");
		System.out.println("First word starting with Q: " + temp + ".");
		words = buildList();
		optionalString = words.filter(s -> s.startsWith("Q")).filter(s->s.length()>8).findFirst();
		temp = optionalString.orElse("No matching results found.");
		System.out.println("First word starting with Q: " + temp);
	}
	
	public static void section8(){
		Stream<String> words = buildList().distinct();
//		words.forEach(System.out::println);
//		String[] temp = words.toArray(String[]::new);
//		int count = 0;
//		for(String s : temp){
//			count++;
//			System.out.println(count +": "+ s);
//		}
		String allInOne = words.collect(Collectors.joining(", "));
		System.out.println(allInOne);
	}
	
	private static Stream<String> buildList(){
		Stream<String> result = null;
		try {
			String contents = new String(Files.readAllBytes(Paths.get("lipsum25para.txt")),StandardCharsets.UTF_8);
			List<String> words = Arrays.asList(contents.split("\\PL+"));
			result = words.stream();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return result;
	}
	
	public static <T> void show(String title, Stream<T> stream){
		final int SIZE = 10;
		List<T> firstElements = stream.limit(SIZE+1).collect(Collectors.toList());
		System.out.print(title+": ");
		for(int i = 0; i < firstElements.size();i++){
			if(i > 0) System.out.print(", ");
			if(i < SIZE) System.out.print(firstElements.get(i));
			else System.out.print("...");
		}
		System.out.println();
	}
}
