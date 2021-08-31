import { NativeModules } from 'react-native';

type WalleChannelType = {
  multiply(a: number, b: number): Promise<number>;
};

const { WalleChannel } = NativeModules;

export default WalleChannel as WalleChannelType;
