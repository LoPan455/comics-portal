package marvel.model;

import java.awt.Image;
import java.net.URL;
import java.util.ArrayList;

public class Comic {

  int marvelApiId;

  /**
   * The ID of the digital comic representation of this comic. Will be 0 if the comic is not available digitally.,
   */
  int digitalId;

  /**
   *  (string, optional): The canonical title of the comic
   */
  String title;

  double issueNumber;

  String variantDescription;
  String description;
//  Date modified;
  String isbn;
  String upc;
  String diamondCode;
  String ean;
  String issn;
  String format;
  int pageCount;
  ArrayList<String> textObjects;
  String resourceURI;
  ArrayList<URL> urls;
//  SeriesSummary series;
//  ArrayList<ComicSummary> variants;
//  ArrayList<ComicSummary> collections;
//  ArrayList<ComicSummary> collectedIssues;
//  ArrayList<ComicDate> keyDates;
  Image thumbnail;
  ArrayList<Image> promoImages;
//  CreatorList creators;
//  CharacterList characters;
//  StoryList stories;
//  EventList events;
}
