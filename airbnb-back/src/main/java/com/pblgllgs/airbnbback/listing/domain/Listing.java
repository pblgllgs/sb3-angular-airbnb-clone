package com.pblgllgs.airbnbback.listing.domain;
/*
 *
 * @author pblgl
 * Created on 12-05-2024
 *
 */

import com.pblgllgs.airbnbback.sharedkernel.domain.AbstractAuditingEntity;
import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "listing")
public class Listing extends AbstractAuditingEntity<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "listingSequenceGenerator")
    @SequenceGenerator(name = "listingSequenceGenerator", sequenceName = "listing_generator", allocationSize = 1)
    @Column(name = "id")
    private Long id;
    @UuidGenerator
    @Column(name = "public_id", nullable = false)
    private UUID publicId;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "guests")
    private int guests;
    @Column(name = "bedrooms")
    private int bedrooms;
    @Column(name = "beds")
    private int beds;
    @Column(name = "bathrooms")
    private int bathrooms;
    @Column(name = "price")
    private int price;
    @Enumerated(EnumType.STRING)
    @Column(name = "category")
    private BookingCategory bookingCategory;
    @Column(name = "location")
    private String location;
    @Column(name = "landlord_public_id")
    private UUID landlordPublicId;
    @OneToMany(mappedBy = "listing", cascade = CascadeType.REMOVE)
    private Set<ListingPicture> pictures = new HashSet<>();

    @Override
    public Long getId() {
        return id;
    }

    public UUID getPublicId() {
        return publicId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getGuests() {
        return guests;
    }

    public int getBedrooms() {
        return bedrooms;
    }

    public int getBeds() {
        return beds;
    }

    public int getBathrooms() {
        return bathrooms;
    }

    public int getPrice() {
        return price;
    }

    public BookingCategory getBookingCategory() {
        return bookingCategory;
    }

    public String getLocation() {
        return location;
    }

    public UUID getLandlordPublicId() {
        return landlordPublicId;
    }

    public Set<ListingPicture> getPictures() {
        return pictures;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPublicId(UUID publicId) {
        this.publicId = publicId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setGuest(int guests) {
        this.guests = guests;
    }

    public void setBedrooms(int bedrooms) {
        this.bedrooms = bedrooms;
    }

    public void setBed(int beds) {
        this.beds = beds;
    }

    public void setBathrooms(int bathrooms) {
        this.bathrooms = bathrooms;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setBookingCategory(BookingCategory bookingCategory) {
        this.bookingCategory = bookingCategory;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setLandlordPublicId(UUID landlordPublicId) {
        this.landlordPublicId = landlordPublicId;
    }

    public void setPictures(Set<ListingPicture> pictures) {
        this.pictures = pictures;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Listing listing = (Listing) o;
        return guests == listing.guests && bedrooms == listing.bedrooms && beds == listing.beds && price == listing.price && Objects.equals(title, listing.title) && Objects.equals(description, listing.description) && Objects.equals(bathrooms, listing.bathrooms) && bookingCategory == listing.bookingCategory && Objects.equals(location, listing.location) && Objects.equals(landlordPublicId, listing.landlordPublicId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description, guests, bedrooms, beds, bathrooms, price, bookingCategory, location, landlordPublicId);
    }

    @Override
    public String toString() {
        return "Listing{" +
                "landlordPublicId=" + landlordPublicId +
                ", location='" + location + '\'' +
                ", bookingCategory=" + bookingCategory +
                ", price=" + price +
                ", bathrooms='" + bathrooms + '\'' +
                ", bed=" + beds +
                ", bedrooms=" + bedrooms +
                ", guest=" + guests +
                ", description='" + description + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
