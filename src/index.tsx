import { NativeModules } from 'react-native';

type WalleChannelType = {
  getChannel(): Promise<string>;
  getExtraInfo(): Promise<{
    [key: string]: string;
  }>;
};

const { WalleChannel } = NativeModules;

export default WalleChannel as WalleChannelType;
