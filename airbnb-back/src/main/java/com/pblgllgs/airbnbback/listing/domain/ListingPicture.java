package com.pblgllgs.airbnbback.listing.domain;
/*
 *
 * @author pblgl
 * Created on 12-05-2024
 *
 */

import com.pblgllgs.airbnbback.sharedkernel.domain.AbstractAuditingEntity;
import jakarta.persistence.*;

import java.util.Arrays;
import java.util.Objects;

@Entity
@Table(name = "listing_picture")
public class ListingPicture extends AbstractAuditingEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "listingPictureSequenceGenerator")
    @SequenceGenerator(name = "listingPictureSequenceGenerator", sequenceName = "listing_picture_generator", allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(
            name = "listing_fk", referencedColumnName = "id"
    )
    private Listing listing;

    @Lob
    @Column(name = "file", nullable = false)
    private byte[] file;

    @Column(name = "file_content_type")
    private String fileContentType;

    @Column(name = "is_cover")
    private boolean isCover;

    @Override
    public Long getId() {
        return id;
    }

    public Listing getListing() {
        return listing;
    }

    public byte[] getFile() {
        return file;
    }

    public String getFileContentType() {
        return fileContentType;
    }

    public boolean isCover() {
        return isCover;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setListing(Listing listing) {
        this.listing = listing;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }

    public void setFileContentType(String fileContentType) {
        this.fileContentType = fileContentType;
    }

    public void setCover(boolean cover) {
        isCover = cover;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListingPicture that = (ListingPicture) o;
        return isCover == that.isCover && Objects.deepEquals(file, that.file) && Objects.equals(fileContentType, that.fileContentType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Arrays.hashCode(file), fileContentType, isCover);
    }

    @Override
    public String toString() {
        return "ListingPicture{" +
                "id=" + id +
                ", listing=" + listing +
                ", file=" + Arrays.toString(file) +
                ", fileContentType='" + fileContentType + '\'' +
                ", isCover=" + isCover +
                '}';
    }
}
