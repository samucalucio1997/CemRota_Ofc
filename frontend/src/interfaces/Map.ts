import { FeatureCollection, Geometry } from 'geojson';

export interface Coordinates {
  latitude: number;
  longitude: number;
}

export interface ViewProps {
  latitude: number;
  longitude: number;
  zoom: number;
}

export interface MapComponentProps {
  viewport: ViewProps;
  coordinates: Coordinates | null;
  route: FeatureCollection<Geometry>;
  setViewPort: (viewport: ViewProps) => void;
}
