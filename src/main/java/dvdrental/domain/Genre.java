/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvdrental.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author bulelani
 */
@Entity
public class Genre implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String horror;
    private String comedy;

    public String getTitle() {
        return title;
    }

    private Genre() {
    }

    public Genre(Builder builder) {
        horror = builder.horror;
        comedy = builder.comedy;
         title = builder.title;
    }

    public static class Builder {

        private String title;
        private String horror;
        private String comedy;

        public Builder(String title) {
            this.title = title;
        }

        public Builder comedy(String value) {
            this.comedy = value;
            return this;
        }
        public Builder horror(String value) {
            this.horror = value;
            return this;
        }
        public Builder copy(Genre value) {
            this.horror = value.getHorror();
            this.comedy = value.getComedy();
            this.title = value.getTitle();
            return this;
        }

        public Genre build() {
            return new Genre(this);
        }
    }

    public Long getId() {
        return id;
    }

    public String getHorror() {
        return horror;
    }

    public String getComedy() {
        return comedy;
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
        if (!(object instanceof Genre)) {
            return false;
        }
        Genre other = (Genre) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dvdrental.domain.Genre[ id=" + id + " ]";
    }

}
