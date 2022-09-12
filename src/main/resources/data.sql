-- expects the csv on the classpath (src/main/resources)
INSERT INTO SONGS (TITLE, ARTIST, TOP_GENRE, YEAR_RELEASED, ADDED, DUR, TOP_YEAR, ARTIST_TYPE)
SELECT TITLE,
       ARTIST,
       TOP_GENRE,
       YEAR_RELEASED,
       ADDED,
       DUR,
       TOP_YEAR,
       ARTIST_TYPE
FROM CSVREAD('classpath:Spotify_2010_2019_Top_100.csv');


INSERT INTO ARTISTS (mbid, artist_mb, country_mb, listeners_lastfm)
SELECT mbid, artist_mb, country_mb, listeners_lastfm
FROM CSVREAD('classpath:musicians.csv');