/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dvdrental.domain;

import javax.persistence.Embeddable;

/**
 *
 * @author bulelani
 */
@Embeddable
public class Ranking {

    private int rank;

    private Ranking() {
    }

    public Ranking(Builder builder) {
        rank = builder.rank;
    }

    public static class Builder {

        private int rank;

        public Builder(int rank) {
            this.rank = rank;
        }

        public Builder copy(Ranking value) {
            rank = value.getRank();
            return this;
        }

        public Ranking build() {
            return new Ranking(this);
        }
    }

    public int getRank() {
        return rank;
    }
}
