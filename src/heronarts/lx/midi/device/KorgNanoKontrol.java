/**
 * Copyright 2013- Mark C. Slee, Heron Arts LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * @author Mark C. Slee <mark@heronarts.com>
 */

package heronarts.lx.midi.device;

import javax.sound.midi.MidiDevice;

import heronarts.lx.LX;
import heronarts.lx.midi.LXMidiDevice;
import heronarts.lx.midi.LXMidiInput;
import heronarts.lx.midi.LXMidiSystem;
import heronarts.lx.parameter.LXParameter;

public class KorgNanoKontrol extends LXMidiDevice {

  public static final int SLIDER_1 = 2;
  public static final int SLIDER_2 = 3;
  public static final int SLIDER_3 = 4;
  public static final int SLIDER_4 = 5;
  public static final int SLIDER_5 = 6;
  public static final int SLIDER_6 = 8;
  public static final int SLIDER_7 = 9;
  public static final int SLIDER_8 = 12;
  public static final int SLIDER_9 = 13;

  public static final int[] SLIDERS = { SLIDER_1, SLIDER_2, SLIDER_3, SLIDER_4,
      SLIDER_5, SLIDER_6, SLIDER_7, SLIDER_8, SLIDER_9, };

  public static final int KNOB_1 = 14;
  public static final int KNOB_2 = 15;
  public static final int KNOB_3 = 16;
  public static final int KNOB_4 = 17;
  public static final int KNOB_5 = 18;
  public static final int KNOB_6 = 19;
  public static final int KNOB_7 = 20;
  public static final int KNOB_8 = 21;
  public static final int KNOB_9 = 22;

  public static final int[] KNOBS = { KNOB_1, KNOB_2, KNOB_3, KNOB_4, KNOB_5,
      KNOB_6, KNOB_7, KNOB_8, KNOB_9, };

  public static final int BOTTOM_BUTTON_1 = 33;
  public static final int BOTTOM_BUTTON_2 = 34;
  public static final int BOTTOM_BUTTON_3 = 35;
  public static final int BOTTOM_BUTTON_4 = 36;
  public static final int BOTTOM_BUTTON_5 = 37;
  public static final int BOTTOM_BUTTON_6 = 38;
  public static final int BOTTOM_BUTTON_7 = 39;
  public static final int BOTTOM_BUTTON_8 = 40;
  public static final int BOTTOM_BUTTON_9 = 41;

  public static final int[] BOTTOM_BUTTONS = { BOTTOM_BUTTON_1,
      BOTTOM_BUTTON_2, BOTTOM_BUTTON_3, BOTTOM_BUTTON_4, BOTTOM_BUTTON_5,
      BOTTOM_BUTTON_6, BOTTOM_BUTTON_7, BOTTOM_BUTTON_8, BOTTOM_BUTTON_9, };

  public static final int TOP_BUTTON_1 = 23;
  public static final int TOP_BUTTON_2 = 24;
  public static final int TOP_BUTTON_3 = 25;
  public static final int TOP_BUTTON_4 = 26;
  public static final int TOP_BUTTON_5 = 27;
  public static final int TOP_BUTTON_6 = 28;
  public static final int TOP_BUTTON_7 = 29;
  public static final int TOP_BUTTON_8 = 30;
  public static final int TOP_BUTTON_9 = 31;

  public static final int[] TOP_BUTTONS = { TOP_BUTTON_1, TOP_BUTTON_2,
      TOP_BUTTON_3, TOP_BUTTON_4, TOP_BUTTON_5, TOP_BUTTON_6, TOP_BUTTON_7,
      TOP_BUTTON_8, TOP_BUTTON_9, };

  public static final String[] DEVICE_NAMES = { "SLIDER/KNOB KORG INC.",
      "nanoKONTROL", "NANOKONTROL", };

  public static final int REWIND = 47;
  public static final int PLAY = 45;
  public static final int FORWARD = 48;
  public static final int LOOP = 49;
  public static final int STOP = 46;
  public static final int RECORD = 44;

  public static MidiDevice matchInputDevice() {
    return LXMidiSystem.matchInputDevice(DEVICE_NAMES);
  }

  public static KorgNanoKontrol getNanoKontrol(LX lx) {
    LXMidiInput input = LXMidiSystem.matchInput(lx, DEVICE_NAMES);
    if (input != null) {
      return new KorgNanoKontrol(input);
    }
    return null;
  }

  public KorgNanoKontrol(LXMidiInput input) {
    super(input);
  }

  public KorgNanoKontrol bindSlider(LXParameter parameter, int slider) {
    bindController(parameter, 0, SLIDERS[slider]);
    return this;
  }

  public KorgNanoKontrol bindBottomButton(LXParameter parameter,
      int bottomButton) {
    bindController(parameter, 0, BOTTOM_BUTTONS[bottomButton]);
    return this;
  }

  public KorgNanoKontrol bindTopButton(LXParameter parameter, int topButton) {
    bindController(parameter, 0, TOP_BUTTONS[topButton]);
    return this;
  }

  public KorgNanoKontrol bindKnob(LXParameter parameter, int knob) {
    bindController(parameter, 0, KNOBS[knob]);
    return this;
  }
}
