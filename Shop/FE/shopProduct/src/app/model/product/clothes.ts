import {Images} from './images';

export interface Clothes {
  id?: number;
  name?: string;
  description?: string;
  price?: number;
  dateSubmitted?: string;
  quantity?: number;
  deleteStatus?: number;
  images?: Images[];
}
