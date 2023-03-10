import {Images} from './images';
import {Img} from './img';

export interface Clothes {
  id?: number;
  name?: string;
  description?: string;
  price?: number;
  dateSubmitted?: string;
  quantity?: number;
  deleteStatus?: number;
  images?: Img[];
  gender?: string;
}
