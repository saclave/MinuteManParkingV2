import React, { Component } from 'react';

import { Image } from 'antd';

import HomePageContentTitle from './HomePageContentTitle';

import parking from '../images/parking.jpg';

class HomePageAboutUs extends Component {
    render() {
        return (
            <div className="home-page-content">
                <HomePageContentTitle id="about_us" text="About Us" />
                <Image width={1000} src={parking} />
            </div >
        );
    }
}

export default HomePageAboutUs;