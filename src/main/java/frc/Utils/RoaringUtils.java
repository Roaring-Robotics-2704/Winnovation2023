package frc.Utils;

public class RoaringUtils {
    public static class DeadzoneUtils {
         public static double LinearDeadband(double rawInput, double deadzone) {
            double slope = 1/(1-deadzone);
            double sign = rawInput/Math.abs(rawInput);
            if (Math.abs(rawInput)>deadzone) {
              return slope*(rawInput - (sign*deadzone));
            } else {
              return 0;
            }
          }
      }
  }