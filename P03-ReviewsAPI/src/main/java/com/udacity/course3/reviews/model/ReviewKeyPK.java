package com.udacity.course3.reviews.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by prisca on 2019/09/04.
 */
@Embeddable
public class ReviewKeyPK implements Serializable {

    @Column(name = "comment_id")
    private Comment comment;

    @Column(name = "product_id")
    private Product product;

    // standard constructors, getters, and setters
    // hashcode and equals implementation


    public ReviewKeyPK() {
    }

    public ReviewKeyPK(Comment comment, Product product) {
        this.comment = comment;
        this.product = product;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReviewKeyPK that = (ReviewKeyPK) o;

        if (comment != null ? !comment.equals(that.comment) : that.comment != null) return false;
        return product != null ? product.equals(that.product) : that.product == null;
    }

    @Override
    public int hashCode() {
        int result = comment != null ? comment.hashCode() : 0;
        result = 31 * result + (product != null ? product.hashCode() : 0);
        return result;
    }
}
