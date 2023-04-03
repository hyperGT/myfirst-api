package br.com.pisco.myfirstapi;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "principaisLinguagens")
public class Language {
    //Collections
    //declarar os atributos como o "titulo/nome", a imagem, e o ranking
    @Id
    private String id;
    private String title;
    private String image;
    private int ranking;



    public Language(String id, String title, String image, int ranking) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.ranking = ranking;
    }

    public String getId() { return id;}

    public String getTitle() {
        return title;
    }

    public String getImage() {
        return image;
    }

    public int getRanking() {
        return ranking;
    }

    public void setId(String id) {
        this.id = id;
    }
}
