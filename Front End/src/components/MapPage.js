import React, { Component } from 'react';
import { withScriptjs, withGoogleMap, GoogleMap, Marker, InfoWindow, } from "react-google-maps";

class MapPage extends Component {

    state = {
        address: "",
        city: "",
        area: "",
        state: "",
        zoom: 15,
        height: 400,
        mapPosition: {
            lat: 0,
            lng: 0,
        } ,
        markerPosition: {
            lat: 0,
            lng: 0,
        }
    }

    
    render() {
        const MapWithAMarker = withScriptjs(withGoogleMap(props =>
            <GoogleMap
                defaultZoom={8}
                defaultCenter={{ lat: -34.397, lng: 150.644 }}
            >
                <Marker
                    draggable = {true}
                    onDragEnd = {this.onDragEnd}
                    position={{ lat: -34.397, lng: 150.644 }}
                >
                    <InfoWindow>
                        <div>
                            Sample Location
                        </div>
                    </InfoWindow>
                </Marker>
            </GoogleMap>
        ));
        return (
            <MapWithAMarker
                googleMapURL="https://maps.googleapis.com/maps/api/js?key=AIzaSyBfcBAIc0tdsDnV-UZqPxC1nyYBupfpPHE&v=3.exp&libraries=geometry,drawing,places"
                loadingElement={<div style={{ height: `100%` }} />}
                containerElement={<div style={{ height: `400px` }} />}
                mapElement={<div style={{ height: `100%` }} />}
            />
        );
    }
}

export default MapPage;