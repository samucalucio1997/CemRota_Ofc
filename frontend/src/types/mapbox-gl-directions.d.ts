declare module '@mapbox/mapbox-gl-directions/dist/mapbox-gl-directions' {
    import { Map } from 'mapbox-gl';
  
    interface DirectionsOptions {
      accessToken: string;
      unit?: 'metric' | 'imperial';
      profile?: 'driving' | 'walking' | 'cycling';
      alternatives?: boolean;
      congestion?: boolean;
      geometries?: 'geojson' | 'polyline';
      controls?: {
        inputs?: boolean;
        instructions?: boolean;
        profileSwitcher?: boolean;
      };
      flyTo?: boolean;
      zoom?: number;
      placeholderOrigin?: string;
      placeholderDestination?: string;
    }
  
    class MapboxDirections {
      constructor(options: DirectionsOptions);
      setOrigin(origin: string | [number, number]): void;
      setDestination(destination: string | [number, number]): void;
      onAdd(map: Map): HTMLElement;
      onRemove(): void;
    }
  
    export default MapboxDirections;
  }
  