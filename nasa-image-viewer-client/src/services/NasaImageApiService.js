import { HTTP, BASE_URL } from './HTTP';

export default {
  getRoverList() {
    return HTTP.get('/api/v1/rovers');
  },

  getDateList() {
    return HTTP.get('/api/v1/dates');
  },

  getPhotoList(roverName, date) {
    return HTTP.get(`/api/v1/rovers/${roverName}/photos?earth_date=${date}`);
  },

  getPhotoUrl(photo) {
    return `${BASE_URL}/api/v1/rovers/${photo.rover.name}/photos/${photo.id}?img_src=${photo.img_src}`;
  }

}