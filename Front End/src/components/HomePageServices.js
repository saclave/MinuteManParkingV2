import React, { Component } from 'react';

import HomePageContentTitle from './HomePageContentTitle';

class HomePageServices extends Component {
    render() {
        return (
            <div className="home-page-content">
                <HomePageContentTitle id="services" text="Services" />
            </div>
        );
    }
}

export default HomePageServices;