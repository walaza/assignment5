/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvdrental.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 *
 * @author bulelani
 */
@Entity
public class DVD implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private int noOfCopies;
    private String yearReleased;
    private double price;
    @Embedded
    private Ranking ranking;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "dvd_id")
    private List<Genre> genre;

    private DVD() {
    }

    public DVD(Builder builder) {
        title = builder.title;
        noOfCopies = builder.noOfCopies;
        yearReleased = builder.yearReleased;
        price = builder.price;
        ranking = builder.ranking;
        genre = builder.genre;
    }

    public static class Builder {

        private String title;
        private int noOfCopies;
        private String yearReleased;
        private double price;
        private Ranking ranking;
        private List<Genre> genre;

        public Builder(String title) {
            this.title = title;
        }

        public Builder noOfCopies(int value) {
            this.noOfCopies = value;
            return this;
        }

        public Builder yearReleased(String value) {
            this.yearReleased = value;
            return this;
        }

        public Builder price(double value) {
            this.price = value;
            return this;
        }

        public Builder ranking(Ranking value) {
            this.ranking = value;
            return this;
        }

        public Builder genre(List<Genre> value) {
            this.genre = value;
            return this;
        }

        public Builder copy(DVD value) {
            this.title = value.getTitle();
            this.noOfCopies = value.getNoOfCopies();
            this.yearReleased = value.getYearReleased();
            this.price = value.getPrice();
            this.ranking = value.getRanking();
            this.genre = value.getGenre();
            return this;
        }

        public DVD build() {
            return new DVD(this);
        }
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getNoOfCopies() {
        return noOfCopies;
    }

    public String getYearReleased() {
        return yearReleased;
    }

    public double getPrice() {
        return price;
    }

    public Ranking getRanking() {
        return ranking;
    }

    public List<Genre> getGenre() {
        return genre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DVD)) {
            return false;
        }
        DVD other = (DVD) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dvdrental.domain.DVD[ id=" + id + " ]";
    }

}
