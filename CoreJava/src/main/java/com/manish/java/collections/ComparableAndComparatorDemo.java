package com.manish.java.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author Manish
 *
 */
public class ComparableAndComparatorDemo implements Comparable<ComparableAndComparatorDemo>{

	private String movieName;
	private Integer movieRating;
	private Integer movieYear;
	public ComparableAndComparatorDemo(String movieName, Integer movieRating, Integer movieYear) {
		super();
		this.movieName = movieName;
		this.movieRating = movieRating;
		this.movieYear = movieYear;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public Integer getMovieRating() {
		return movieRating;
	}
	public void setMovieRating(Integer movieRating) {
		this.movieRating = movieRating;
	}
	public Integer getMovieYear() {
		return movieYear;
	}
	public void setMovieYear(Integer movieYear) {
		this.movieYear = movieYear;
	}
	@Override
	public int compareTo(ComparableAndComparatorDemo o) {
		return (this.movieName.compareTo(o.movieName));
	}
	
	
	@Override
	public String toString() {
		return "ComparableAndComparatorDemo [movieName=" + movieName + ", movieRating=" + movieRating + ", movieYear="
				+ movieYear + "]";
	}
	public static void main(String[] args) {
		List<ComparableAndComparatorDemo> list = new ArrayList<>();
		list.add(new ComparableAndComparatorDemo("Manish", 8, 2012));
		list.add(new ComparableAndComparatorDemo("Khushboo", 7, 2014));
		list.add(new ComparableAndComparatorDemo("Pawan", 10, 2016));
		list.add(new ComparableAndComparatorDemo("Pooja", 1, 2017));
		System.out.println(list);
		Collections.sort(list);
		System.out.println(list);
		Collections.sort(list, new RatingComparator());
		System.out.println(list);
	}
	
	

}
class RatingComparator implements Comparator<ComparableAndComparatorDemo>{

	@Override
	public int compare(ComparableAndComparatorDemo o1, ComparableAndComparatorDemo o2) {
		if(o1.getMovieRating() > o2.getMovieRating()) return -1;
		else if(o1.getMovieRating() < o2.getMovieRating()) return 1;
		else return 0;
	}
	
}
