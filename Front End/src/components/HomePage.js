import React, { Component } from 'react';

import MPHeader from './MPHeader';
import HomePageAbout from './HomePageAbout';
import HomePageMap from './HomePageMap';
import HomePageSider from './HomePageSider';
import HomePageServices from './HomePageServices';

import { Layout } from 'antd';

const { Content } = Layout;

class HomePage extends Component {
    render() {
        return (
            <Layout>
                <MPHeader />
                <Layout>
                    <HomePageSider />
                    <Layout style={{ padding: '0 24px 24px' }}>
                        <br />
                        <Content
                            className="site-layout-background"
                            style={{
                                padding: 24,
                                margin: 0,
                                minHeight: 280,
                            }}
                        >
                            <HomePageServices />
                            <HomePageMap />
                            <HomePageAbout />
                        </Content>
                    </Layout>
                </Layout>
            </Layout>
        );
    }
}

export default HomePage;