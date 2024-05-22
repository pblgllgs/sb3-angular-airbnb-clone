package com.pblgllgs.airbnbback.listing.application;
/*
 *
 * @author pblgl
 * Created on 14-05-2024
 *
 */

import com.pblgllgs.airbnbback.listing.application.dto.sub.PictureDTO;
import com.pblgllgs.airbnbback.listing.domain.Listing;
import com.pblgllgs.airbnbback.listing.domain.ListingPicture;
import com.pblgllgs.airbnbback.listing.mapper.ListingPictureMapper;
import com.pblgllgs.airbnbback.listing.repository.ListingPictureRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class PictureService {

    private final ListingPictureRepository listingPictureRepository;

    private final ListingPictureMapper listingPictureMapper;

    public PictureService(ListingPictureRepository listingPictureRepository, ListingPictureMapper listingPictureMapper) {
        this.listingPictureRepository = listingPictureRepository;
        this.listingPictureMapper = listingPictureMapper;
    }

    public List<PictureDTO> saveAll(List<PictureDTO> pictures, Listing listing) {
        Set<ListingPicture> listingPictures = listingPictureMapper.pictureDTOsToListingPictures(pictures);

        boolean isFirst = true;

        for (ListingPicture listingPicture : listingPictures) {
            listingPicture.setCover(isFirst);
            listingPicture.setListing(listing);
            isFirst = false;
        }

        listingPictureRepository.saveAll(listingPictures);
        return listingPictureMapper.listingPictureToPictureDTO(listingPictures.stream().toList());
    }
}